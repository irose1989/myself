package service;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wb-chenchaobin on 2015/11/30.
 */
public class LoginTest extends BaseTest{
    private String username="zhang";
    private String password="123";

    @Test
    public void testLoginSuccess(){
        loginWithSpringConfig(username, password);
        Assert.assertTrue(subject().isAuthenticated());
    }
    @Test
    public void testLoginWithWrongUsername(){
        loginWithSpringConfig(username + 1, password);
        Assert.assertTrue(subject().isAuthenticated());
    }
    @Test
    public void testLoginWithWrongPassword(){
        loginWithSpringConfig(username, password + 1);
        Assert.assertTrue(subject().isAuthenticated());
    }
    @Test
    public void testLoginWithLockedAccount() {
        loginWithSpringConfig("wang",password);
        Assert.assertTrue(subject().isAuthenticated());
    }
    @Test
    public void testLimistAttemptToLogin(){
        for (int i = 0; i < 5; i++) {
            System.out.println("===============");
            loginWithSpringConfig(username , password+1);
            System.out.println("尝试登入第" + (i + 1) + "次");
        }
        System.out.println("尝试登入第" + 6 + "次");
        loginWithSpringConfig(username , password);
    }
}
