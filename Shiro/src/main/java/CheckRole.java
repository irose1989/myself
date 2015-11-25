import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wb-chenchaobin on 2015/11/25.
 */
public class CheckRole extends  BaseTest {
    @Test
    public void testHasRole(){
        login("classpath:shiro-role.ini", "zhang", "123");
        Assert.assertTrue(getSubject().hasRole("role1"));
        Assert.assertTrue(getSubject().hasRole("role2"));
        Assert.assertFalse(getSubject().hasRole("role3"));
        boolean result[] = getSubject().hasRoles(Arrays.asList("role1","role2","role3"));
        Assert.assertEquals(true,result[0]);
        Assert.assertEquals(true,result[1]);
        Assert.assertEquals(false,result[2]);
    }
    @Test
    public void testCheckRole(){
        login("classpath:shiro-role.ini", "zhang", "123");
        getSubject().checkRole("role1");
        getSubject().checkRoles("role1", "role2");
    }
    @Test
    public void testCheckPerssion(){
        login("classpath:shiro-permission.ini","wang","123");
//        getSubject().checkPermission("user:update");
        getSubject().isPermitted("user:create","user:select");
    }
}

