package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wb-chenchaobin on 2015/11/26.
 */
public class TestRole extends BaseTest{
    @Test
    public void testRole1(){
        login("classpath:test/test-shiro-role.ini", "zhang", "123");
        Assert.assertTrue(getSubject().hasRole("role1"));
        Assert.assertTrue(getSubject().hasRole("role2"));
        Assert.assertTrue(getSubject().hasAllRoles(Arrays.asList("role1", "role2")));
    }
    @Test
    public void testRole2(){
        login("classpath:test/test-shiro-role.ini", "wang", "234");
        Assert.assertFalse(getSubject().hasRole("role1"));
        Assert.assertTrue(getSubject().hasRole("role2"));
    }
}
