package comp3350.umhub.business;

import comp3350.umhub.application.Services;

public class Login {

    public Login(String[] info) throws LoginException {
        if(info[0].isEmpty() || info[1].isEmpty())
        {
            throw new LoginException("Please enter valid credentials!");
        }
        if(!Services.getLoginPersistence().userExist(info[0],info[1])){
            Services.getLoginPersistence().insertUser(info[0],info[1]);
        }
    }

    public class LoginException extends Exception{

        public LoginException(){
            super();
        }

        public LoginException(String message){
            super(message);
        }
    }

}

