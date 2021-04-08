package comp3350.umhub.persistence.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Course;
import comp3350.umhub.persistence.ICoursePersistence;

public class CourseSQLDB implements ICoursePersistence {
    public static final String TABLE_NAME = "COURSES";
    public static final String _ID = "_id";
    public static final String NAME = "NAME";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String YEAR = "YEAR";
    public static final String MAJOR = "MAJOR";

    public static String[] ALL_COLUMNS = {_ID, NAME, DESCRIPTION, YEAR, MAJOR};

    private SQLiteDatabase database; // may later implement as singleton
    public CourseSQLDB(Context context) {
        database = Services.getDatabase(context);
    }

    @Override
    public Course getCourse(String courseId) {
        Course course = null;
        try {
            Cursor cursor = database.query(TABLE_NAME, ALL_COLUMNS, _ID + "='" + courseId+"'", null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                String id = cursor.getString(cursor.getColumnIndex(_ID));
                String name = cursor.getString(cursor.getColumnIndex(NAME));
                String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION));
                int year = cursor.getInt(cursor.getColumnIndex(YEAR));
                String major = cursor.getString(cursor.getColumnIndex(MAJOR));
                course = new Course(id, name,description,year,major);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return course;
        }
    }

    @Override
    public List<Course> getCoursesSequential() {
        final List<Course> courses = new ArrayList<>();
        try {
            Cursor cursor = database.query(TABLE_NAME, ALL_COLUMNS, null, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String id = cursor.getString(cursor.getColumnIndex(_ID));
                    String name = cursor.getString(cursor.getColumnIndex(NAME));
                    String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION));
                    int year = cursor.getInt(cursor.getColumnIndex(YEAR));
                    String major = cursor.getString(cursor.getColumnIndex(MAJOR));
                    courses.add(new Course(id, name,description,year,major));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return courses;
        }
    }

    @Override
    public List<Course> getCoursesByMajor(String myMajor) {
        final List<Course> courses = new ArrayList<>();
        try {
            String WHERE_CLAUSE = String.format("%s = '%s'",MAJOR,myMajor);
            Cursor cursor = database.query(TABLE_NAME, ALL_COLUMNS, WHERE_CLAUSE, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String id = cursor.getString(cursor.getColumnIndex(_ID));
                    String name = cursor.getString(cursor.getColumnIndex(NAME));
                    String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION));
                    int year = cursor.getInt(cursor.getColumnIndex(YEAR));
                    String major = cursor.getString(cursor.getColumnIndex(MAJOR));
                    courses.add(new Course(id, name,description,year,major));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return courses;
        }
    }

    @Override
    public List<Course> getCoursesByYearMajor(String myMajor, int myYear) {
        final List<Course> courses = new ArrayList<>();
        try {
            String WHERE_CLAUSE = String.format("%s = '%s' and %s = %d",MAJOR,myMajor,YEAR,myYear);
            Cursor cursor = database.query(TABLE_NAME, ALL_COLUMNS, WHERE_CLAUSE, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String id = cursor.getString(cursor.getColumnIndex(_ID));
                    String name = cursor.getString(cursor.getColumnIndex(NAME));
                    String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION));
                    int year = cursor.getInt(cursor.getColumnIndex(YEAR));
                    String major = cursor.getString(cursor.getColumnIndex(MAJOR));
                    courses.add(new Course(id, name,description,year,major));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return courses;
        }
    }

    @Override
    public List<Course> getCoursesByProgram(String program) {
        return null;
    }

    @Override
    public List<Course> getCoursesByYearProgram(String program, int year) {
        return null;
    }




    public void insert(String courseID, String name, String desc, int year, String major){
        ContentValues contentValue = new ContentValues();
        contentValue.put(_ID, courseID);
        contentValue.put(NAME,name);
        contentValue.put(DESCRIPTION, desc);
        contentValue.put(YEAR, year);
        contentValue.put(MAJOR, major);
        database.insert(TABLE_NAME, null, contentValue);
    }


}
