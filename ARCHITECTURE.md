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
|                                               |                                          |   +--------+                            |
|                                               | AccessMajors                             |                                         |
|                                               |                                          |  MajorPersistenceStub                   |
|                                               |                                          |  ProgramPersistenceStub                 |
|                                               |                                          |                                         |
+-----------------------------------------------+------------------------------------------+-----------------------------------------+

                                                    Domain Specific Objects

                                                     Course
                                                     Major
                                                     Program
                                                     Student
