package comp3350.umhub.persistence.stubs;
import java.util.ArrayList;

import comp3350.umhub.objects.Users;
import comp3350.umhub.persistence.ILoginPersistence;

public class LoginPersistenceStub implements ILoginPersistence {
    ArrayList<Users> database;

    public LoginPersistenceStub(){
        database = new ArrayList<>();
    }

    @Override
    public void insertUser(String username, String password){
        database.add(new Users(username, password));
    }

    @Override
    public boolean userExist(String username, String password){
        for(int i = 0; i < database.size(); i++){
            Users temp = database.get(i);
            if(temp.getUserName().equals(username) && temp.getPassword().equals(password))
                return true;
        }
        return false;
    }
}
