//used to provide an implementation of the interfaces used.
package comp3350.umhub.application;

import comp3350.umhub.business.IAccessCourses;
import comp3350.umhub.business.AccessCourses;
import comp3350.umhub.business.IAccessMajors;
import comp3350.umhub.business.AccessMajors;
import comp3350.umhub.business.IAccessPrograms;
import comp3350.umhub.business.AccessPrograms;

import comp3350.umhub.persistence.ICoursePersistence;
import comp3350.umhub.persistence.IMajorPersistence;
import comp3350.umhub.persistence.hsqldb.CoursePersistenceHSQLDB;
import comp3350.umhub.persistence.hsqldb.MajorPersistenceHSQLDB;
import comp3350.umhub.persistence.hsqldb.ProgramPersistenceHSQLDB;
import comp3350.umhub.persistence.stubs.MajorPersistenceStub;

import comp3350.umhub.persistence.ILoginPersistence;
import comp3350.umhub.persistence.stubs.LoginPersistenceStub;

import comp3350.umhub.persistence.IMajorPersistence;
import comp3350.umhub.persistence.ICoursePersistence;
import comp3350.umhub.persistence.IProgramPersistence;
import comp3350.umhub.persistence.stubs.CoursePersistenceStub;
import comp3350.umhub.persistence.stubs.ProgramPersistenceStub;

public class Services {
    private static IAccessMajors accessMajors = null;
    private static IAccessPrograms accessPrograms = null;
    private static IAccessCourses accessCourses = null;
    private static IMajorPersistence majorPersistence = null;
    private static IProgramPersistence programPersistence = null;
    private static ICoursePersistence coursePersistence;

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

    public static synchronized ICoursePersistence getCoursePersistence(){
        if(coursePersistence==null){
            //coursePersistence = new CoursePersistenceStub();
            coursePersistence = new CoursePersistenceHSQLDB(Main.getDBPathName());
        }
        return coursePersistence;
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

    
    public static synchronized IAccessCourses getAccessCourses(){
        if(accessCourses==null){
            accessCourses = new AccessCourses();
        }
        return accessPrograms;
    }
    
    public static synchronized ILoginPersistence getLoginPersistence(){
        if(loginPersistence==null){
            loginPersistence = new LoginPersistenceStub();
        }
        return loginPersistence;
    }
}
