package comp3350.umhub.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.old.IProgramPersistence;

public class ProgramPersistenceHSQLDB implements IProgramPersistence {

    private final String dbPath;

    public ProgramPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private synchronized Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private synchronized Program fromResultSet(final ResultSet rs) throws SQLException {
        final String programName = rs.getString("name");
        final String majorName = rs.getString("mName");
        return new Program(programName,majorName);
    }

    @Override
    public synchronized List<Program> getProgramsSequential() {
        final List<Program> programs = new ArrayList<>();

        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM programs");
            while (rs.next())
            {
                final Program program = fromResultSet(rs);
                programs.add(program);
            }
            rs.close();
            st.close();

            return programs;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }


}

