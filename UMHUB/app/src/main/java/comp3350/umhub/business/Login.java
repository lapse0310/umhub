package comp3350.umhub.business;

import javax.security.auth.login.LoginException;

import comp3350.umhub.application.Services;
import comp3350.umhub.application.SignUpException;
import comp3350.umhub.application.UserException;
import comp3350.umhub.objects.User;
import comp3350.umhub.persistence.interfaces.ILoginPersistence;

public class Login implements ILogin{
    private ILoginPersistence userPersistence;
    String currentUser = null;

    public Login()
    {
        userPersistence = Services.getLoginPersistence(null);
    }

    public Login(final ILoginPersistence userPersistence)
    {
        this.userPersistence = userPersistence;
    }

    @Override
    public void signUp(String[] info) throws SignUpException {
        try {
            if (this.userPersistence.getUser(info[0]) != null) {
                throw new SignUpException("Username is already taken !");
            }
        }catch(UserException e){
            throw new SignUpException("Error checking if username has been taken");
        }

        try {
            this.userPersistence.insertUser(info[0],info[1]);
        }catch(UserException e){
            throw new SignUpException("Error adding user to signed-up users");
        }
    }

    @Override
    public void login(String[] info) throws LoginException {

        try {
            User userVerify = this.userPersistence.getUser(info[0]);
            if (userVerify == null) {
                throw new LoginException("Invalid username or password");
            } else if (!userVerify.getPassword().equals(info[1])) {
                throw new LoginException("Invalid username or password");
            } else {
                this.currentUser = info[0];
            }
        }catch(UserException e){
            throw new LoginException("Invalid username or password"); //there really was just a problem logging in, but its bad for security for the user to know that
        }
    }

    @Override
    public String getCurrentUser() {
        return this.currentUser;
    }
}


