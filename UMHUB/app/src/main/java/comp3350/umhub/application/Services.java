//used to provide an implementation of the interfaces used.
package comp3350.umhub.application;

import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;

import comp3350.umhub.business.AccessCourseReviews;
import comp3350.umhub.business.AccessTutors;
import comp3350.umhub.business.AccessUsers;
import comp3350.umhub.business.IAccessCourseReviews;
import comp3350.umhub.business.IAccessCourses;
import comp3350.umhub.business.AccessCourses;
import comp3350.umhub.business.IAccessMajors;
import comp3350.umhub.business.AccessMajors;
import comp3350.umhub.business.IAccessPrograms;
import comp3350.umhub.business.AccessPrograms;

import comp3350.umhub.business.IAccessUsers;
import comp3350.umhub.business.ILogin;
import comp3350.umhub.business.Login;
import comp3350.umhub.business.IAccessTutors;
import comp3350.umhub.objects.User;

import comp3350.umhub.persistence.sqlite.CourseReviewSQLDB;
import comp3350.umhub.persistence.sqlite.CourseSQLDB;
import comp3350.umhub.persistence.sqlite.DatabaseHelper;
import comp3350.umhub.persistence.sqlite.DatabaseNotCreatedException;
import comp3350.umhub.persistence.sqlite.UserSQLDB;
import comp3350.umhub.persistence.sqlite.MajorSQLDB;
import comp3350.umhub.persistence.sqlite.ProgramSQLDB;

import comp3350.umhub.persistence.interfaces.IMajorPersistence;
import comp3350.umhub.persistence.interfaces.ICoursePersistence;
import comp3350.umhub.persistence.interfaces.IProgramPersistence;
import comp3350.umhub.persistence.interfaces.ICourseReviewPersistence;
import comp3350.umhub.persistence.interfaces.IUserPersistence;
import comp3350.umhub.persistence.interfaces.ITutorPersistence;

import comp3350.umhub.persistence.stubs.TutorPersistenceStub;


public class Services {
    private static IAccessMajors accessMajors = null;
    private static IAccessPrograms accessPrograms = null;
    private static IAccessCourses accessCourses = null;
    private static IMajorPersistence majorPersistence = null;
    private static IProgramPersistence programPersistence = null;
    private static ICoursePersistence coursePersistence = null;
    private static IUserPersistence loginPersistence = null;
    private static ICourseReviewPersistence courseReviewPersistence = null;
    private static IAccessCourseReviews accessCourseReviews;
    private static ILogin userLogin = null;
    private static IAccessTutors accessTutors = null;
    private static ITutorPersistence tutorPersistence = null;
    private static SQLiteDatabase database;
    private static IAccessUsers accessUsers;

    public static void logOut(){
        if (accessUsers != null) accessUsers.setCurrentUser((User) null);
    }

    public static User getCurrentUser() {
        if (accessUsers != null) return accessUsers.getCurrentUser();
        return null;
    }

    public static synchronized IMajorPersistence getMajorPersistence(){
        if (majorPersistence == null){
                majorPersistence = new MajorSQLDB();
        }
        return majorPersistence;
    }

    public static synchronized IProgramPersistence getProgramPersistence(){
        if (programPersistence == null){
                programPersistence = new ProgramSQLDB();
        }
        return programPersistence;
    }

    public static synchronized ICoursePersistence getCoursePersistence(){
        if (coursePersistence == null){
                coursePersistence = new CourseSQLDB();
        }
        return coursePersistence;
    }

    public static ICourseReviewPersistence getCourseReviewPersistence() {
        if (courseReviewPersistence == null){
                courseReviewPersistence = new CourseReviewSQLDB();
        }
        return courseReviewPersistence;
    }

    public static synchronized IAccessMajors getAccessMajors(){
        if (accessMajors == null){
            accessMajors = new AccessMajors(Services.getMajorPersistence());
        }
        return accessMajors;
    }

    public static synchronized IAccessPrograms getAccessPrograms(){
        if (accessPrograms == null){
            accessPrograms = new AccessPrograms(Services.getProgramPersistence());
        }
        return accessPrograms;
    }


    public static synchronized IAccessCourses getAccessCourses(){
        if (accessCourses == null){
            accessCourses = new AccessCourses(Services.getCoursePersistence());
        }
        return accessCourses;
    }


    public static IAccessCourseReviews getAccessCourseReviews() {
        if (accessCourseReviews == null){
            accessCourseReviews = new AccessCourseReviews(Services.getCourseReviewPersistence());
        }
        return accessCourseReviews;

    }

    public static synchronized IUserPersistence getUserPersistence(){
        if (loginPersistence == null){
                loginPersistence = new UserSQLDB();
        }
        return loginPersistence;
    }

    public static synchronized ILogin getILogin(){
        if(userLogin == null){
            userLogin = new Login(Services.getAccessUsers());
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


    public static SQLiteDatabase getDatabase() throws DatabaseNotCreatedException {
        if(database ==null){
            try {
                DatabaseHelper dbHelper = new DatabaseHelper();
                database = dbHelper.getDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return database;
    }

    public static IAccessUsers getAccessUsers() {
        if(accessUsers == null){
            accessUsers = new AccessUsers(Services.getUserPersistence());
        }
        return accessUsers;
    }

}
