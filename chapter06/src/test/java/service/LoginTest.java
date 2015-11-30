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
        login("classpath:realm/shiro_login.ini",username,password);
        Assert.assertTrue(subject().isAuthenticated());
    }
    @Test
    public void testLoginWithWrongUsername(){
        login("classpath:realm/shiro_login.ini",username+1,password);
        Assert.assertTrue(subject().isAuthenticated());
    }
    @Test
    public void testLoginWithWrongPassword(){
        login("classpath:realm/shiro_login.ini",username,password+1);
        Assert.assertTrue(subject().isAuthenticated());
    }
    @Test
    public void testLoginWithLockedAccount(){
        login("classpath:realm/shiro_login.ini","wang",password);
        Assert.assertTrue(subject().isAuthenticated());
    }
}
