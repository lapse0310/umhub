package comp3350.umhub.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.objects.User;
import comp3350.umhub.persistence.ICourseReviewPersistence;

public class CourseReviewPersistenceHSQLDB implements ICourseReviewPersistence {

    private final String dbPath;

    public CourseReviewPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    @Override
    public List<CourseReview> getCourseReviewsSequential() {
        final List<CourseReview> courseReviews = new ArrayList<>();

        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM COURSEREVIEWS");
            while (rs.next()) {
                final CourseReview review = fromResultSet(rs);
                courseReviews.add(review);
            }
            rs.close();
            st.close();

            return courseReviews;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<CourseReview> getCourseReviewsSequential(String courseId) {
        final List<CourseReview> courseReviews = new ArrayList<>();

        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM COURSEREVIEWS WHERE courseID=?");
            st.setString(1, courseId);
            final ResultSet rs = st.executeQuery();

            while (rs.next()) {
                final CourseReview review = fromResultSet(rs);
                courseReviews.add(review);
            }
            rs.close();
            st.close();

            return courseReviews;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void insert(String courseID, String userID, String review, int reviewScore) {
        try (final Connection c = connection()) {

            final PreparedStatement st = c.prepareStatement("INSERT INTO COURSEREVIEWS (COURSEID,USERNAME,REVIEW,SCORE) VALUES (?,?,?,?)");
            st.setString(1, courseID);
            st.setString(2, userID);
            st.setString(4, review);
            st.setInt(3, reviewScore);

            final ResultSet rs = st.executeQuery();
            rs.close();
            st.close();

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private CourseReview fromResultSet(final ResultSet rs) throws SQLException {
        final int id = rs.getInt("id");
        final String courseId = rs.getString("courseID");
        final String userId = rs.getString("username");
        final String review = rs.getString("review");
        final int score = rs.getInt("score");
        //return new CourseReview(id,new User(username), new Course(courseId), score, reviewString); //This looks hideous
        return new CourseReview(id,userId,courseId,review,score);
    }


}
