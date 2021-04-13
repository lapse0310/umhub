package comp3350.umhub.persistence.sqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import comp3350.umhub.BuildConfig;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context mycontext;
    private SQLiteDatabase myDataBase;
    private boolean DELETE_OLD_DB = false;


    // Database Information
    private static final String DB_PATH = "/data/user/0/" + BuildConfig.APPLICATION_ID + "/databases/";
    static final String DB_NAME = "newdb.db";
    static final String DB_SCRIPT = "newdb.script";

    // database version
    static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) throws IOException, DatabaseNotCreatedException {
        super(context, DB_NAME, null, DB_VERSION);
        this.mycontext = context;
        boolean dbexist = checkdatabase();
        if (dbexist) {
            opendatabase();
        } else {
            createdatabase();
            throw new DatabaseNotCreatedException("Database doesn't exist");
        }

    }

    public void opendatabase() throws SQLException {
        //Open the database
        String mypath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    private void createdatabase() throws IOException {
        //Open your local db as the input stream
        String mypath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openOrCreateDatabase(mypath, null);

        InputStream is = mycontext.getAssets().open(DB_SCRIPT);
        String str = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            if (is != null) {
                while ((str = reader.readLine()) != null) {
                    myDataBase.execSQL(str);
                }
            }
        } finally {
            try {
                is.close();
            } catch (Throwable ignore) {
            }
        }
    }


    private boolean checkdatabase() {

        boolean checkdb = false;
        try {

            File dbFolder = new File(DB_PATH);

            if (!dbFolder.exists())
                dbFolder.mkdirs();

            String myPath = DB_PATH + DB_NAME;
            File dbfile = new File(myPath);
            checkdb = dbfile.exists();

        } catch (SQLiteException e) {
            System.out.println("Database doesn't exist");
        }
        return checkdb;
    }

    public synchronized void close() {
        if (myDataBase != null) {
            myDataBase.close();
        }
        super.close();
    }

    public SQLiteDatabase getDataBase() {
        return myDataBase;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
