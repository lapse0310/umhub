package comp3350.umhub.persistence.interfaces;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.application.UserException;
import comp3350.umhub.objects.User;

public interface ILoginPersistence {
    public void insertUser(String username, String password) throws UserException;
    //public boolean userExist(String username, String Password );
    public User getUser(String username) throws UserException;
    public List<User> getAllUsers() throws UserException;
}



