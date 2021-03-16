package comp3350.umhub.tests.business;

import org.junit.Test;

import comp3350.umhub.application.Services;
import comp3350.umhub.business.AccessCourseReviews;
import comp3350.umhub.business.AccessMajors;
import comp3350.umhub.business.AccessPrograms;
import comp3350.umhub.business.IAccessCourseReviews;
import comp3350.umhub.business.IAccessMajors;
import comp3350.umhub.business.IAccessPrograms;
import comp3350.umhub.objects.Major;
import comp3350.umhub.persistence.ICourseReviewPersistence;
import comp3350.umhub.persistence.IMajorPersistence;
import comp3350.umhub.persistence.IProgramPersistence;
import comp3350.umhub.persistence.stubs.CourseReviewPersistenceStub;
import comp3350.umhub.persistence.stubs.MajorPersistenceStub;
import comp3350.umhub.persistence.stubs.ProgramPersistenceStub;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ServicesTest {


    @Test
    public void testGetMajorPersistenceStubDefault(){
        System.out.println("\nStarting test testGetMajorPersistentStubParam");

        IMajorPersistence majorPersistenceStub = Services.getMajorPersistence();

        assertNotNull("Persistence Object is Null",majorPersistenceStub);
        assertTrue("Persistence Object is not of MajorPersistenceStub class",majorPersistenceStub instanceof MajorPersistenceStub);
        System.out.println("Finished test testGetMajorPersistentStubParam");


    };

    @Test
    public void testGetMajorPersistenceStubParam(){
        System.out.println("\nStarting test testGetMajorPersistentStubParam");

        IMajorPersistence majorPersistenceStub = Services.getMajorPersistence(MajorPersistenceStub.class);

        assertNotNull("Persistence Object is Null",majorPersistenceStub);
        assertTrue("Persistence Object is not of MajorPersistenceStub class",majorPersistenceStub instanceof MajorPersistenceStub);
        System.out.println("Finished test testGetMajorPersistentStubParam");

    };

    @Test
    public void testGetProgramPersistenceStubDefault(){
        System.out.println("\nStarting test testGetProgramPersistenceStubDefault");

        IProgramPersistence programPersistence = Services.getProgramPersistence();

        assertNotNull("Persistence Object is Null",programPersistence);
        assertTrue("Persistence Object is not of ProgramPersistenceStub class",programPersistence instanceof ProgramPersistenceStub);
        System.out.println("Finished test testGetProgramPersistenceStubDefault");


    };

    @Test
    public void testGetProgramPersistenceStubParam(){
        System.out.println("\nStarting test testGetProgramPersistenceStubParam");

        IProgramPersistence programPersistence = Services.getProgramPersistence(ProgramPersistenceStub.class);

        assertNotNull("Persistence Object is Null",programPersistence);
        assertTrue("Persistence Object is not of ProgramPersistenceStub class",programPersistence instanceof ProgramPersistenceStub);
        System.out.println("Finished test testGetProgramPersistenceStubParam");

    };

    @Test
    public void testGetCourseReviewPersistenceStubDefault(){
        System.out.println("\nStarting test testGetCourseReviewPersistenceStubDefault");

        ICourseReviewPersistence courseReviewPersistence = Services.getCourseReviewPersistence();

        assertNotNull("Persistence Object is Null",courseReviewPersistence);
        assertTrue("Persistence Object is not of CourseReviewPersistenceStub class",courseReviewPersistence instanceof CourseReviewPersistenceStub);
        System.out.println("Finished test testGetCourseReviewPersistenceStubDefault");


    };

    @Test
    public void testGetCourseReviewPersistenceStubParam(){
        System.out.println("\nStarting test testGetCourseReviewPersistenceStubParam");

        ICourseReviewPersistence courseReviewPersistence = Services.getCourseReviewPersistence(CourseReviewPersistenceStub.class);

        assertNotNull("Persistence Object is Null",courseReviewPersistence);
        assertTrue("Persistence Object is not of CourseReviewPersistenceStub class",courseReviewPersistence instanceof CourseReviewPersistenceStub);
        System.out.println("Finished test testGetCourseReviewPersistenceStubParam");

    };

    @Test
    public void testAccessMajorsDefault(){
        System.out.println("\nStarting test testAccessMajorsDefault");

        IAccessMajors accessMajors = Services.getAccessMajors();

        assertNotNull("Access Object is Null",accessMajors);
        assertTrue("Access Object is not of AccessMajors class",accessMajors instanceof AccessMajors);
        System.out.println("Finished test testAccessMajorsDefault");


    };

    @Test
    public void testAccessMajorsParam(){
        System.out.println("\nStarting test testAccessMajorsParam");

        IAccessMajors accessMajors = Services.getAccessMajors(AccessMajors.class);

        assertNotNull("Access Object is Null",accessMajors);
        assertTrue("Access Object is not of AccessMajors class",accessMajors instanceof AccessMajors);
        System.out.println("Finished test testAccessMajorsParam");
    };

    @Test
    public void testAccessProgramsDefault(){
        System.out.println("\nStarting test testAccessProgramsDefault");

        IAccessPrograms accessPrograms = Services.getAccessPrograms();

        assertNotNull("Access Object is Null",accessPrograms);
        assertTrue("Access Object is not of AccessPrograms class",accessPrograms instanceof AccessPrograms);
        System.out.println("Finished test testAccessProgramsDefault");
    };

    @Test
    public void testAccessProgramsParam(){
        System.out.println("\nStarting test testAccessProgramsParam");

        IAccessPrograms accessPrograms = Services.getAccessPrograms(AccessPrograms.class);

        assertNotNull("Access Object is Null",accessPrograms);
        assertTrue("Access Object is not of AccessPrograms class",accessPrograms instanceof AccessPrograms);
        System.out.println("Finished test testAccessProgramsParam");
    };

    @Test
    public void testAccessCourseReviewsDefault(){
        System.out.println("\nStarting test testAccessCourseReviewsDefault");

        IAccessCourseReviews accessCourseReviews = Services.getAccessCourseReviews();

        assertNotNull("Access Object is Null",accessCourseReviews);
        assertTrue("Access Object is not of AccessCourseReviews class",accessCourseReviews instanceof AccessCourseReviews);
        System.out.println("Finished test testAccessCourseReviewsDefault");


    };

    @Test
    public void testAccessCourseReviewsParam(){
        System.out.println("\nStarting test testAccessCourseReviewsDefault");

        IAccessCourseReviews accessCourseReviews = Services.getAccessCourseReviews(AccessCourseReviews.class);

        assertNotNull("Access Object is Null",accessCourseReviews);
        assertTrue("Access Object is not of AccessCourseReviews class",accessCourseReviews instanceof AccessCourseReviews);
        System.out.println("Finished test testAccessCourseReviewsDefault");

    };

}
