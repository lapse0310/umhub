//used to provide an implementation of the interfaces used.
package comp3350.umhub.application;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;

import comp3350.umhub.business.AccessCourseReviews;
import comp3350.umhub.business.AccessTutors;
import comp3350.umhub.business.IAccessCourseReviews;
import comp3350.umhub.business.IAccessCourses;
import comp3350.umhub.business.AccessCourses;
import comp3350.umhub.business.IAccessMajors;
import comp3350.umhub.business.AccessMajors;
import comp3350.umhub.business.IAccessPrograms;
import comp3350.umhub.business.AccessPrograms;

import comp3350.umhub.business.ILogin;
import comp3350.umhub.business.Login;
import comp3350.umhub.business.IAccessTutors;
import comp3350.umhub.objects.User;

import comp3350.umhub.persistence.sqlite.CourseReviewSQLDB;
import comp3350.umhub.persistence.sqlite.CourseSQLDB;
import comp3350.umhub.persistence.sqlite.DatabaseHelper;
import comp3350.umhub.persistence.sqlite.MajorSQLDB;
import comp3350.umhub.persistence.sqlite.ProgramSQLDB;
import comp3350.umhub.persistence.stubs.CoursePersistenceStub;
import comp3350.umhub.persistence.stubs.CourseReviewPersistenceStub;
import comp3350.umhub.persistence.stubs.LoginPersistenceStub;

import comp3350.umhub.persistence.interfaces.IMajorPersistence;
import comp3350.umhub.persistence.interfaces.ICoursePersistence;
import comp3350.umhub.persistence.interfaces.IProgramPersistence;
import comp3350.umhub.persistence.interfaces.ICourseReviewPersistence;
import comp3350.umhub.persistence.interfaces.ILoginPersistence;
import comp3350.umhub.persistence.interfaces.ITutorPersistence;

import comp3350.umhub.persistence.stubs.MajorPersistenceStub;
import comp3350.umhub.persistence.stubs.ProgramPersistenceStub;
import comp3350.umhub.persistence.stubs.TutorPersistenceStub;


public class Services {

    private static User currentUser;
    private static IAccessMajors accessMajors = null;
    private static IAccessPrograms accessPrograms = null;
    private static IAccessCourses accessCourses = null;
    private static IMajorPersistence majorPersistence = null;
    private static IProgramPersistence programPersistence = null;
    private static ICoursePersistence coursePersistence = null;
    private static ILoginPersistence loginPersistence = null;
    private static ICourseReviewPersistence courseReviewPersistence = null;
    private static AccessCourseReviews accessCourseReviews;
    private static ILogin userLogin = null;
    private static IAccessTutors accessTutors = null;
    private static ITutorPersistence tutorPersistence = null;
    private static SQLiteDatabase database;


    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user){
        currentUser = user;
    }

    public static synchronized IMajorPersistence getMajorPersistence(Context context){
        if (majorPersistence == null){
            if (context == null)
                majorPersistence = new MajorPersistenceStub();
            else
                majorPersistence = new MajorSQLDB(context);

        }
        return majorPersistence;
    }

    public static synchronized IProgramPersistence getProgramPersistence(Context context){
        if (programPersistence == null){
            if (context == null)
                programPersistence = new ProgramPersistenceStub();
            else
                programPersistence = new ProgramSQLDB(context);
        }
        return programPersistence;
    }

    public static synchronized ICoursePersistence getCoursePersistence(Context context){
        if (coursePersistence == null){
            if (context == null)
                coursePersistence = new CoursePersistenceStub();
            else
                coursePersistence = new CourseSQLDB(context);
        }
        return coursePersistence;
    }

    public static ICourseReviewPersistence getCourseReviewPersistence(Context context) {
        if (courseReviewPersistence == null){
            if (context == null)
                courseReviewPersistence = new CourseReviewPersistenceStub();
            else
                courseReviewPersistence = new CourseReviewSQLDB(context);
        }
        return courseReviewPersistence;
    }

    public static synchronized IAccessMajors getAccessMajors(Context context){
        if (accessMajors == null){
            accessMajors = new AccessMajors(Services.getMajorPersistence(context));
        }
        return accessMajors;
    }

    public static synchronized IAccessPrograms getAccessPrograms(Context context){
        if (accessPrograms == null){
            accessPrograms = new AccessPrograms(Services.getProgramPersistence(context));
        }
        return accessPrograms;
    }


    public static synchronized IAccessCourses getAccessCourses(Context context){
        if (accessCourses == null){
            accessCourses = new AccessCourses(Services.getCoursePersistence(context));
        }
        return accessCourses;
    }


    public static IAccessCourseReviews getAccessCourseReviews(Context context) {

        if (accessCourseReviews == null){
            accessCourseReviews = new AccessCourseReviews(Services.getCourseReviewPersistence(context));
        }
        return accessCourseReviews;

    }

    public static synchronized ILoginPersistence getLoginPersistence(){
        if(loginPersistence==null){
            loginPersistence = new LoginPersistenceStub();
        }
        return loginPersistence;
    }

    public static synchronized ILogin userLogin(){
        if(userLogin == null){
            userLogin = new Login();
        }
        return userLogin;
        
        }
        
    public static synchronized ITutorPersistence getTutorPersistence(){
        if(tutorPersistence==null){
            tutorPersistence = new TutorPersistenceStub();


        }
        return tutorPersistence;
    }

    public static IAccessTutors getAccessTutors() {

        if (accessTutors == null) {
            accessTutors = new AccessTutors();
        }
        return accessTutors;
    }


    public static SQLiteDatabase getDatabase(Context context) {
        if(database ==null){
            try {
                DatabaseHelper dbHelper = new DatabaseHelper(context);
                database = dbHelper.getDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return database;
    }

//    public static CourseReviewSQLDB getCourseReviewSQLDB(Context context) {
//        return new CourseReviewSQLDB(context);
//    }
}
