package comp3350.umhub.tests.objects;

import org.junit.Test;

import comp3350.umhub.objects.User;

import static org.junit.Assert.*;

public class UsersTest {

    @Test
    public void testUser1(){
        User user1;

        System.out.println("\nStarting testUser1");

        user1 = new User("Admin", "12345");

        assertNotNull(user1);
        assertTrue("Admin".equals(user1.getUsername()));
        assertTrue("12345".equals(user1.getPassword()));

        System.out.println("Finished testUser1");
    }


}
