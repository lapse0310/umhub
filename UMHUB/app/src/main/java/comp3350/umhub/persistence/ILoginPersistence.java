package comp3350.umhub.persistence;

import java.util.ArrayList;

import comp3350.umhub.application.UserException;
import comp3350.umhub.objects.User;

public interface ILoginPersistence {
    public void insertUser(String username, String password) throws UserException;
    //public boolean userExist(String username, String Password );
    public User getUser(String username) throws UserException;
    public ArrayList<User> getAllUsers() throws UserException;
}



