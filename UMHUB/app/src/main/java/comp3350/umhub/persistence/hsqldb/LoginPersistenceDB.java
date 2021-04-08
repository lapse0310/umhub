package comp3350.umhub.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import comp3350.umhub.objects.User;
import comp3350.umhub.persistence.ILoginPersistence;

public class LoginPersistenceDB implements ILoginPersistence {
    private final String dbPath;

    public LoginPersistenceDB(final String dbPath){
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:"+ dbPath +";shutdown=true", "SA", "");
    }

    @Override
    public void insertUser(String username, String password){
        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement(
                    "insert into users (username,password) values (?, ?);"
            );

            st.setString(1, username );
            st.setString(2, password );
            st.executeUpdate();
            st.close();

        } catch (final SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public User getUser(String username){

        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement(
                    "select * from users where username = ?"
            );
            st.setString(1, username);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()){
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                return new User(userName,password);
            }
            st.close();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return null;
    }

    public ArrayList<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<>();
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement(
                    "select * from users"
            );
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()){
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                users.add(new User(userName,password));
            }
            st.close();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return users;
    }

}

