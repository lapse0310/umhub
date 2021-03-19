package comp3350.umhub.persistence;

public interface ILoginPersistence {
    public void insertUser(String username, String password);
    public boolean userExist(String username, String password);
}

