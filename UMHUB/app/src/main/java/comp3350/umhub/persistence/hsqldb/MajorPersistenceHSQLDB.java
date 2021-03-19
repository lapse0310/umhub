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
import comp3350.umhub.objects.Major;
import comp3350.umhub.persistence.IMajorPersistence;

public class MajorPersistenceHSQLDB implements IMajorPersistence {


    private final String dbPath;

    public MajorPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Major fromResultSet(final ResultSet rs) throws SQLException {
        final String majorID = rs.getString("majorID");
        final String majorName = rs.getString("name");
        return new Major(majorID,majorName);
    }

    @Override
    public List<Major> getMajorsSequential() {
        final List<Major> majors = new ArrayList<>();

        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM majors");
            while (rs.next())
            {
                final Major major = fromResultSet(rs);
                majors.add(major);
            }
            rs.close();
            st.close();

            return majors;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<Major> getMajorRandom(Major currentMajor) {
        final List<Major> majors = new ArrayList<>();

        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM majors WHERE majorID=?");
            st.setString(1, currentMajor.getId());

            final ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                final Major major = fromResultSet(rs);
                majors.add(major);
            }
            rs.close();
            st.close();

            return majors;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }
}
