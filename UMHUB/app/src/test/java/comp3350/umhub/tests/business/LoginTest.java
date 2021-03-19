package comp3350.umhub.tests.business;

import comp3350.umhub.business.Login;

import org.junit.Test;

public class LoginTest {

    private Login testLogin;

    private final String[] user1Input = {"",""};
    private final String[] user2Input = {"", "password2"};
    private final String[] user3Input = {"user1", ""};
    private final String[] user4Input = {"user1", "password1"};


    @Test(expected = Login.LoginException.class)
    public void testInvalidLogin() throws Login.LoginException
    {
        System.out.println("\nStarting test testInvalidLogin");
        testLogin = new Login(user1Input);                       /* Test login with empty username,password */
        System.out.println("Finished test testInvalidLogin");
    }

    @Test(expected = Login.LoginException.class)
    public void testInvalidName() throws Login.LoginException
    {
        System.out.println("\nStarting test testInvalidName");
        testLogin = new Login(user2Input);                       /* Test login with empty username */
        System.out.println("Finished test testInvalidName");
    }

    @Test(expected = Login.LoginException.class)
    public void testInvalidPass() throws Login.LoginException
    {
        System.out.println("\nStarting test testInvalidPass");
        testLogin = new Login(user3Input);                       /* Test login with empty password */
        System.out.println("Finished test testInvalidPass");
    }

    @Test
    public void testValidLogin() throws Login.LoginException
    {
        System.out.println("\nStarting test testValidLogin");
        testLogin = new Login(user4Input);                       /* Test login with valid username,password */
        System.out.println("Finished test testValidLogin");
    }

}

