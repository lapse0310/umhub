package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.objects.User;

public interface IAccessUsers {
    String getCurrentUser();
    List<User> getAllUsers();
    User getUser(String uid);

}
