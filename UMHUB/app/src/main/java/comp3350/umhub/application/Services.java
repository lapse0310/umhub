//used to provide an implementation of the interfaces used.
package comp3350.umhub.application;

import comp3350.umhub.business.AccessCourseReviews;
import comp3350.umhub.business.IAccessCourseReviews;
import comp3350.umhub.business.IAccessCourses;
import comp3350.umhub.business.AccessCourses;

import comp3350.umhub.business.IAccessMajors;
import comp3350.umhub.business.AccessMajors;

import comp3350.umhub.business.IAccessPrograms;
import comp3350.umhub.business.AccessPrograms;

import comp3350.umhub.objects.User;
import comp3350.umhub.persistence.ICourseReviewPersistence;
import comp3350.umhub.persistence.IMajorPersistence;
import comp3350.umhub.persistence.stubs.CourseReviewPersistenceStub;
import comp3350.umhub.persistence.ICoursePersistence;
import comp3350.umhub.persistence.IMajorPersistence;
import comp3350.umhub.persistence.hsqldb.CoursePersistenceHSQLDB;
import comp3350.umhub.persistence.hsqldb.MajorPersistenceHSQLDB;
import comp3350.umhub.persistence.hsqldb.ProgramPersistenceHSQLDB;
import comp3350.umhub.persistence.stubs.MajorPersistenceStub;

import comp3350.umhub.persistence.ICoursePersistence;
import comp3350.umhub.persistence.IProgramPersistence;

import comp3350.umhub.persistence.stubs.CoursePersistenceStub;
import comp3350.umhub.persistence.stubs.ProgramPersistenceStub;

import comp3350.umhub.persistence.hsqldb.CoursePersistenceHSQLDB;
import comp3350.umhub.persistence.hsqldb.MajorPersistenceHSQLDB;
import comp3350.umhub.persistence.hsqldb.ProgramPersistenceHSQLDB;


public class Services {
    private static User currentUser;
    private static IAccessMajors accessMajors = null;
    private static IAccessPrograms accessPrograms = null;
    private static IAccessCourseReviews accessCourseReviews = null;
    private static IMajorPersistence majorPersistence = null;
    private static IProgramPersistence programPersistence = null;
    private static ICourseReviewPersistence courseReviewPersistence = null;
    private static IAccessCourses accessCourses = null;
    private static ICoursePersistence coursePersistence = null;

    public static synchronized User getCurrentUser() {
        return currentUser;
    }

    public static synchronized void setCurrentUser(User newUser) {
        currentUser = newUser;
    }

    public static synchronized IMajorPersistence getMajorPersistence(){
        if(majorPersistence==null){
            //majorPersistence = new MajorPersistenceStub();
            majorPersistence = new MajorPersistenceHSQLDB(Main.getDBPathName());
        }
        return majorPersistence;
    }

    public static synchronized IMajorPersistence getMajorPersistence(Class c){
        if(majorPersistence==null){
            if (IMajorPersistence.class.isAssignableFrom(c)) {
                try {
                    majorPersistence = (IMajorPersistence) c.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        return majorPersistence;
    }


    public static synchronized IProgramPersistence getProgramPersistence(){
        if(programPersistence==null){
            //programPersistence = new ProgramPersistenceStub();
            programPersistence = new ProgramPersistenceHSQLDB(Main.getDBPathName());
        }
        return programPersistence;
    }


    public static synchronized IProgramPersistence getProgramPersistence(Class c){
        if(programPersistence==null){
            if (IProgramPersistence.class.isAssignableFrom(c)) {
                try {
                    programPersistence = (IProgramPersistence) c.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        return programPersistence;
    }

    public static synchronized ICourseReviewPersistence getCourseReviewPersistence(){
        if(courseReviewPersistence==null){
            courseReviewPersistence = new CourseReviewPersistenceStub();
        }
        return courseReviewPersistence;
    }

    public static synchronized ICourseReviewPersistence getCourseReviewPersistence(Class c){
        if(courseReviewPersistence==null){
            if (ICourseReviewPersistence.class.isAssignableFrom(c)) {
                try {
                    courseReviewPersistence = (ICourseReviewPersistence) c.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        return courseReviewPersistence;
        
    }
       


    public static synchronized IAccessMajors getAccessMajors(){
        if(accessMajors==null){
            accessMajors = new AccessMajors();
        }
        return accessMajors;
    }

    public static synchronized IAccessMajors getAccessMajors(Class c){
        if(accessMajors==null){
            if (IAccessMajors.class.isAssignableFrom(c)) {
                try {
                    accessMajors = (IAccessMajors) c.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        return accessMajors;
    }

    public static synchronized IAccessPrograms getAccessPrograms(){
        if(accessPrograms==null){
            accessPrograms = new AccessPrograms();
        }
        return accessPrograms;
    }

    public static synchronized IAccessPrograms getAccessPrograms(Class c){
        if(accessPrograms==null){
            if (IAccessPrograms.class.isAssignableFrom(c)) {
                try {
                    accessPrograms = (IAccessPrograms) c.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        return accessPrograms;
    }

    public static synchronized IAccessCourseReviews getAccessCourseReviews(){
        if (accessCourseReviews == null){
            accessCourseReviews = new AccessCourseReviews();
        }
        return accessCourseReviews;
    }

    public static synchronized IAccessCourseReviews getAccessCourseReviews(Class c){
        if(accessCourseReviews==null){
            if (IAccessCourseReviews.class.isAssignableFrom(c)) {
                try {
                    accessCourseReviews = (IAccessCourseReviews) c.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        return accessCourseReviews;
    }

    public static synchronized IAccessCourses getAccessCourses(){
        if(accessCourses==null){
            accessCourses = new AccessCourses();
        }
        return accessCourses;
    }

    public static synchronized IAccessCourses getAccessCourses(Class c){
        if(accessCourses==null){
            if (IAccessCourses.class.isAssignableFrom(c)) {
                try {
                    accessCourses = (IAccessCourses) c.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        return accessCourses;
    }

    public static synchronized ICoursePersistence getCoursePersistence(){
        if(coursePersistence==null){
            coursePersistence = new CoursePersistenceHSQLDB(Main.getDBPathName());
        }
        return coursePersistence;
    }

    public static synchronized ICoursePersistence getCoursePersistence(Class c){
        if(coursePersistence==null){
            if (ICoursePersistence.class.isAssignableFrom(c)) {
                try {
                    coursePersistence = (ICoursePersistence) c.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        return coursePersistence;
    }
}
