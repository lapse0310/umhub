
  ```
  +-----------------------------------------------+------------------------------------------+--------------------------------------------------+
  |                   UI Layer                    |                Logic Layer               |          Data Layer                              |
  +-----------------------------------------------------------------------------------------------------------------------------------         -+
  |                                               |                                          |                                                  |
  |             +-----------------+               |  +-------------+       +--------------+  |         +------------------+                     |
  |             |   presentation  |               |  |  business   |       |  application |  |         |   persistence    |                     |
  |             +-----------------+               |  +-------------+       +--------------+  |         +------------------+                     |
  |                                               |                                          |                                                  |
  |                                               |                                          |   +--------+             IMajorPersistence       |
  |HomeActivity  MajorsActivity  ProgramsActivity | IAccessMajors          Services          |   | stubs  |             IProgramPersistence     |
  |                                               | IAccessPrograms        Main              |   +--------+             ICoursePersistence      |
  | Messages     CoursesActivity   LoginActivity  | IAccessCourseReviews                     | MajorPersistenceStub     ILoginPersistence       |
  |                                               | IAccessCourses                           | ProgramPersistenceStub   ICourseReviewPersistence|
  |          WriteCourseReviewActivity            |
Login                                    |
CoursePersistenceStub                            |
  |
                                              |
AccessCourses                            |
CourseReviewPersistenceStub                      |
  |
           CourseReviewActivity               |
AccessCourseReviews                      |
LoginPersistenceStub                             |
  |
                                              |
AccessMajors                             |
 
                                               |
  |
                                              |
AccessPrograms                           |
  +--------+
                                    |
  |
                                              |
Equals                                   |
  | hsqldb |
                                    |
  |
                                              |
                                         |
  +--------+                                     |
  |
                                              |
                                         |
CoursePersistenceHSQLDB                          |
  |
                                              |
                                         |
CourseReviewPersistenceHSQLDB                    |
  |
                                              |
                                         |
MajorPersistenceHSQLDB                           |
  |
                                              |
                                         |
PersistenceException                             |
  |                                               |                                          | ProgramPersistenceHSQLDB                         |
  +-----------------------------------------------+------------------------------------------+--------------------------------------------------+
                                                       Domain Specific Objects

                                                        Course       CourseReview
                                                        Major        CourseReviewProfile
                                                        Program      Review
                                                        Student      User

     ```





