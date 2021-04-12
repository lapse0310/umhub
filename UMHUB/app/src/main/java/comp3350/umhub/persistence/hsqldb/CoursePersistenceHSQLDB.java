package comp3350.umhub.persistence.hsqldb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Course;

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
        final String desc = rs.getString("desc1");
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




}

