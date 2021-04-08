package comp3350.umhub.persistence.stubs;
import java.util.ArrayList;

import comp3350.umhub.objects.User;
import comp3350.umhub.persistence.ILoginPersistence;

public class LoginPersistenceStub implements ILoginPersistence {
    ArrayList<User> database;

    public LoginPersistenceStub() {
        database = new ArrayList<>();
        database.add(new User("admin","123456"));
        database.add(new User("admin1","123456"));
        database.add(new User("admin2","123456"));
        database.add(new User("admin3","123456"));

    }

    @Override
    public void insertUser(String username, String password) {
        database.add(new User(username, password));
    }

    /*@Override
    public boolean userExist(String username, String password){
        for(int i = 0; i < database.size(); i++){
            User temp = database.get(i);
            if(temp.getUserName().equals(username) && temp.getPassword().equals(password))
                return true;
        }
        return false;
    } */

    @Override
    public User getUser(String username) {
        for (int i = 0; i < database.size(); i++) {
            User temp = database.get(i);
            if (temp.getUsername().equals(username))
                return temp;
        }
        return null;
    }

    public ArrayList<User> getAllUsers() {
        return null;
    }

}

