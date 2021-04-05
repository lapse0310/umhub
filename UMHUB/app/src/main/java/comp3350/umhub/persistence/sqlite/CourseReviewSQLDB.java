package comp3350.umhub.persistence.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.application.Services;

public class CourseReviewSQLDB {
    public static final String TABLE_NAME = "COURSEREVIEWS";
    public static final String _ID = "_id";
    public static final String COURSEID = "COURSEID";
    public static final String REVIEW = "REVIEW";
    public static final String SCORE = "SCORE";
    public static final String USERID = "USERID";

    public static String[] COLUMNS = {_ID, COURSEID, USERID, REVIEW, SCORE};

    //private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public CourseReviewSQLDB(Context c) {

        context = c;
        database = Services.getDatabase(context);

    }

/*    public CourseReviewSQLDB open() throws SQLException {
        try {
            dbHelper = new DatabaseHelper(context);
            database = dbHelper.getDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }*/

    public void insert(String courseID, String userID, String review, int reviewScore) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(COURSEID, courseID);
        contentValue.put(USERID, userID);
        contentValue.put(REVIEW, review);
        contentValue.put(SCORE,reviewScore);
        database.insert(TABLE_NAME, null, contentValue);
    }



    public Cursor fetch() {
        //String[] columns = new String[] {_ID};
        Cursor cursor = database.query(TABLE_NAME, COLUMNS, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String courseID, String review) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COURSEID, courseID);
        contentValues.put(REVIEW, review);
        int i = database.update(TABLE_NAME, contentValues, _ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(TABLE_NAME, _ID + "=" + _id, null);
    }


    public List<MyCourseReview> getCourseReviewsSequential() {
        final List<MyCourseReview> courseReviews = new ArrayList<>();
        try {
            Cursor cursor = database.query(TABLE_NAME,COLUMNS,null,null,null,null,null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    int _id = cursor.getInt(cursor.getColumnIndex(_ID));
                    String courseId = cursor.getString(cursor.getColumnIndex(COURSEID));
                    String review = cursor.getString(cursor.getColumnIndex(REVIEW));
                    courseReviews.add(new MyCourseReview(_id,courseId,review));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }    finally {
            return courseReviews;
        }
    }


}
