//package comp3350.umhub.tests.business;
//
//import comp3350.umhub.application.Services;
//import comp3350.umhub.business.Login;
//import comp3350.umhub.objects.User;
//
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class LoginTest {
//
//    private Login testLogin;
//
//    private final String[] user1Input = {"",""};
//    private final String[] user2Input = {"", "password2"};
//    private final String[] user3Input = {"user1", ""};
//    private final String[] user4Input = {"user1", "password1"};
//
//
//    @Test(expected = Login.LoginException.class)
//    public void testInvalidLogin() throws Login.LoginException
//    {
//        System.out.println("\nStarting test testInvalidLogin");
//        testLogin = new Login(user1Input);                       /* Test login with empty username,password */
//        System.out.println("Finished test testInvalidLogin");
//    }
//
//    @Test(expected = Login.LoginException.class)
//    public void testInvalidName() throws Login.LoginException
//    {
//        System.out.println("\nStarting test testInvalidName");
//        testLogin = new Login(user2Input);                       /* Test login with empty username */
//        System.out.println("Finished test testInvalidName");
//    }
//
//    @Test(expected = Login.LoginException.class)
//    public void testInvalidPass() throws Login.LoginException
//    {
//        System.out.println("\nStarting test testInvalidPass");
//        testLogin = new Login(user3Input);                       /* Test login with empty password */
//        System.out.println("Finished test testInvalidPass");
//    }
//
//    @Test
//    public void testValidLogin() throws Login.LoginException
//    {
//        System.out.println("\nStarting test testValidLogin");
//        testLogin = new Login(user4Input);                       /* Test login with valid username,password */
//        System.out.println("Finished test testValidLogin");
//    }
//
//    /*May be considered an Integration Test*/
//    @Test
//    public void testCurrentUser() throws Login.LoginException {
//        System.out.println("\nStarting test testCurrentUser");
//        testLogin = new Login(user4Input);
//
//        User user = Services.getCurrentUser();
//        assertNotNull(user);
//        assertTrue("Username must match!", user.getUsername() == user4Input[0]);
//        assertTrue("Password must match!", user.getPassword() == user4Input[1]);
//
//        System.out.println("Finished test testCurrentUser");
//
//    }
//
//}
//
