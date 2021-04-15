package comp3350.umhub.persistence.sqlite;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Program;
import comp3350.umhub.objects.Utils;
import comp3350.umhub.persistence.interfaces.IProgramPersistence;

public class ProgramSQLDB implements IProgramPersistence {
    public static final String TABLE_PROGRAMS = "PROGRAMS";
    public static final String TABLE_COURSESPROGRAMS = "COURSESPROGRAMS";
    public static final String _ID = "_id";
    public static final String MAJOR = "MAJOR";
    public static String[] COLUMNS_PROGRAMS = {_ID, MAJOR};

    public static final String CP_COURSEID = "COURSEID";
    public static final String CP_PROGRAMID = "PROGRAMID";
    public static String[] COLUMNS_COURSESPROGRAMS = {CP_COURSEID, CP_PROGRAMID};


    private SQLiteDatabase database;

    public ProgramSQLDB() {
        try {
            database = Services.getDatabase();
        } catch (DatabaseNotCreatedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Program getProgram(String pid) {
        Program program = null;
        try {
            String WHERE_CLAUSE = String.format("%s = '%s'", _ID, pid);
            Cursor cursor = database.query(TABLE_PROGRAMS, COLUMNS_PROGRAMS, WHERE_CLAUSE, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                String id = cursor.getString(cursor.getColumnIndex(_ID));
                String major = cursor.getString(cursor.getColumnIndex(MAJOR));
                program = new Program(id, major);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return program;
        }
    }

    @Override
    public List<Program> getProgramsSequential() {
        final List<Program> programs = new ArrayList<>();
        try {
            Cursor cursor = database.query(TABLE_PROGRAMS, COLUMNS_PROGRAMS, null, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String id = cursor.getString(cursor.getColumnIndex(_ID));
                    String major = cursor.getString(cursor.getColumnIndex(MAJOR));
                    programs.add(new Program(id, major));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return programs;
        }
    }

    @Override
    public List<Program> getProgramsByMajor(String myMajor) {
        final List<Program> programs = new ArrayList<>();
        try {
            String WHERE_CLAUSE = String.format("%s = '%s'", MAJOR, myMajor);
            Cursor cursor = database.query(TABLE_PROGRAMS, COLUMNS_PROGRAMS, WHERE_CLAUSE, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String id = cursor.getString(cursor.getColumnIndex(_ID));
                    String major = cursor.getString(cursor.getColumnIndex(MAJOR));
                    programs.add(new Program(id, major));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return programs;
        }
    }

    @Override
    public List<Program> getProgramsByCourse(String course) {
        final List<Program> programs = new ArrayList<>();
        try {
            String rawQuery = String.format("SELECT * FROM COURSESPROGRAMS AS CP JOIN PROGRAMS AS P ON CP.PROGRAMID = P._id WHERE %s = '%s'", "COURSEID", course);
            Cursor cursor = database.rawQuery(rawQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String id = cursor.getString(cursor.getColumnIndex(_ID));
                    String major = cursor.getString(cursor.getColumnIndex(MAJOR));
                    programs.add(new Program(id, major));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return programs;
        }
    }




    private void testGetProgramsSequential() {
        System.out.println("---Test testGetProgramsSequential---");
        List<Program> l = getProgramsSequential();
        System.out.println(Utils.listToString(l));
        assert (l.size()==49);
    }

    private void testGetProgram() {
        System.out.println("---Test testGetProgram---");
        Program c1 = getProgram("Statistics HONOURS");
        Program c2 = getProgram("Economics SINGLE HONOURS - ECONOMICS AND SOCIETY STREAM");
        Program c3 = getProgram("Computer Engineering Departmental Program");
        assert (c1!=null);
        assert (c2!=null);
        assert (c3!=null);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }

    private void testGetProgramsByMajor() {
        System.out.println("---Test testGetProgramsByMajor---");
        List<Program> l = getProgramsByMajor("Philosophy");
        System.out.println(Utils.listToString(l));
        assert (l.size()==8);
    }

    private void testGetProgramsByCourse() {
        System.out.println("---Test testGetProgramsByCourse---");
        List<Program> l = getProgramsByCourse("COMP1010");
        System.out.println(Utils.listToString(l));
        assert (l.size()==13);
    }


}
