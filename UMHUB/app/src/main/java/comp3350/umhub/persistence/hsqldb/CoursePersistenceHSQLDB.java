package comp3350.umhub.persistence.hsqldb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.persistence.ICoursePersistence;

public class CoursePersistenceHSQLDB {

    private final String dbPath;

    public CoursePersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private synchronized Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private synchronized Course fromResultSet(final ResultSet rs) throws SQLException {
        final String courseID = rs.getString("courseID");
        final String courseName = rs.getString("name");
        final String desc = rs.getString("review");
        final String majorName = rs.getString("mNAme");
        final int year = rs.getInt("year");
        //Major newMajor = new Major(majorName);
        //return new Course(courseID, courseName,desc,year,newMajor);
        return new Course(courseID, courseName,desc,year,majorName);
    }



    public synchronized List<Course> getCoursesSequential() {
        final List<Course> courses = new ArrayList<>();

        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM courses");
            while (rs.next())
            {
                final Course course = fromResultSet(rs);
                courses.add(course);
            }
            rs.close();
            st.close();

            return courses;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

//    @Override
//    public List<Course> getCourseRandom(Course currentCourse) {
//        final List<Course> courses = new ArrayList<>();
//
//        try (final Connection c = connection()) {
//            final PreparedStatement st = c.prepareStatement("SELECT * FROM courses WHERE courseID=?");
//            st.setString(1, currentCourse.getId());
//
//            final ResultSet rs = st.executeQuery();
//            while (rs.next())
//            {
//                final Course course = fromResultSet(rs);
//                courses.add(course);
//            }
//            rs.close();
//            st.close();
//
//            return courses;
//        }
//        catch (final SQLException e)
//        {
//            throw new PersistenceException(e);
//        }
//    }


}

