package comp3350.umhub.persistence.sqlite;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import comp3350.umhub.BuildConfig;

public class DatabaseHelper {
    private SQLiteDatabase myDataBase;

    // Database Information
    private static final String DB_PATH = "/data/user/0/" + BuildConfig.APPLICATION_ID + "/databases/";
    static final String DB_NAME = "newdb.db";
    static final String DB_SCRIPT = "newdb.script";


    public DatabaseHelper() throws IOException, DatabaseNotCreatedException {
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

        DBScriptIter scriptIter = new DBScriptIter();
        String str = "";
        while ((str = scriptIter.next()) != null) {
            myDataBase.execSQL(str);
        }
//        try {
//            Scanner reader = new Scanner(DBScript.SCRIPT);
//            if (reader != null) {
//                while ((str = reader.nextLine()) != null) {
//                    myDataBase.execSQL(str);
//                }
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//
//        finally {
//            try {
//                is.close();
//            } catch (Throwable ignore) {
//            }
//        }
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
//        super.close();
    }

    public SQLiteDatabase getDataBase() {
        return myDataBase;
    }

}
