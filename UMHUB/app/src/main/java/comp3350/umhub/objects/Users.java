package comp3350.umhub.objects;

public class Users {

    private String uName;
    private String uPass;

    public Users(String uName)
    {
        this.uName = uName;
    }
    public Users(String uName, String uPass){
        this.uName = uName;
        this.uPass = uPass;
    }

    public String getUserName() {
        return uName;
    }

    public String getPassword() {
        return uPass;
    }
}

