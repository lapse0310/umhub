+-----------------------------------------------+------------------------------------------+-----------------------------------------+
|                   UI Layer                    |                Logic Layer               |          Data Layer                     |
+------------------------------------------------------------------------------------------------------------------------------------+
|                                               |                                          |                                         |
|             +-----------------+               |  +-------------+       +--------------+  |         +------------------+            |
|             |   presentation  |               |  |  business   |       |  application |  |         |   persistence    |            |
|             +-----------------+               |  +-------------+       +--------------+  |         +------------------+            |
|                                               |                                          |                                         |
|                                               |                                          |   +--------+        IMajorPersistence   |
|HomeActivity  MajorsActivity  ProgramsActivity | IAccessMajors          Services          |   | stubs  |        IProgramPersistence |
|                                               | IAccessPrograms                          |   +--------+                            |
|                                               | AccessMajors                             |                                         |
|                                               | AccessPrograms                           |  MajorPersistenceStub                   |
|                                               | Equals                                   |  ProgramPersistenceStub                 |
|                                               |                                          |                                         |
+-----------------------------------------------+------------------------------------------+-----------------------------------------+

                                                    Domain Specific Objects

                                                     Course
                                                     Major
                                                     Program
                                                     Student
