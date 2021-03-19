```
┌───────────────────────────────────────────┬───────────────────────────────────────────────┬───────────────────────────────────────────────────────────┐
│       UI LAYER                            │            LOGIC LAYER                        │        DATA LAYER                                         │
├───────────────────────────────────────────┼───────────────────────────────────────────────┼───────────────────────────────────────────────────────────┤
│                                           │                                               │                                                           │
│         ┌────────────────┐                │ ┌────────────────┐            ┌─────────────┐ │     ┌────────────────────────┐                            │
│         │  PRESENTATION  │                │ │BUSINESS        │            │APPLICATION  │ │     │PERSISTENCE             │                            │
│         └────────────────┘                │ └────────────────┘            └─────────────┘ │     └────────────────────────┘                            │
│                                           │                                               │                                                           │
│      HomeActivity       MajorsActivity    │ IAccessMajors                  Main           │ ┌─────────┐                    IMajorPersistence          │
│      ProgramsActivity   CoursesActivity   │ IAccessPrograms                Services       │ │STUBS    │                    IProgramPersisten         
│
│      Messages           LoginActivity     │ IAccessCourseReviews                          │ └─────────┘                    ICoursePersistence         │
│      WriteCourseReviewActivity            │ IAccessCourses                                │ MajorPersistenceStub           ILoginPersistence          │
│      CourseReviewActivity                 │ Login                                         │ ProgramPersistenceStub         ICourseReviewPersistence   │
│                                           │ AccessCourses                                 │ CourseReviewPersistenceStub                               │
│                                           │ AccessCourseReviews                           │ CoursePersistenceStub                                     │
│                                           │ AccessMajors                                  │ LoginPersistenceStub                                      │
│                                           │ AccessPrograms                                │                                                           │
│                                           │ Equals                                        │ ┌──────────┐                                              │
│                                           │                                               │ │ HSQLDB   │                                              │
│                                           │                                               │ └──────────┘                                              │
│                                           │                                               │ CoursePersistenceHSQLDB                                   │
│                                           │                                               │ CourseReviewPersistenceHSQLDB                             │
│                                           │                                               │ MajorPersistenceHSQLDB                                    │
│                                           │                                               │ PersistenceException                                      │
│                                           │                                               │ ProgramPersistenceHSQLDB                                  │
│                                           │                                               │                                                           │
│                                           │                                               │                                                           │
│                                           │                                               │                                                           │
│                                           │                                               │                                                           │
└───────────────────────────────────────────┴───────────────────────────────────────────────┴───────────────────────────────────────────────────────────┘

                                                Domain Specific Objects

                                          Course             CourseReview
                                          Major              CourseReviewProfile
                                          Program            Review
                                          Student            User
                                          ```