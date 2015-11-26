package test;

import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by wb-chenchaobin on 2015/11/26.
 */
public class TestLogin extends  BaseTest {
    @Test
    public void testLogin(){
        login("classpath:test/test-shiro-realm.ini","wang","234");
        Assert.assertEquals(true, getSubject().isAuthenticated());
    }
    @Test
    public void testRealm1(){
        login("classpath:test/test-shiro-myRealm1.ini", "wang", "123");
        Assert.assertEquals(true, getSubject().isAuthenticated());
    }
    @Test
    public void testRealms(){
        login("classpath:test/test-shiro-myRealms.ini","wang","123");
        System.out.println("登入失败");
        Assert.assertEquals(true, getSubject().isAuthenticated());
    }
    @Test
    public void testAllSuccessStrategy(){
        login("classpath:test/test-shiro-allSucessfulStrategy.ini", "zhang", "123");
        PrincipalCollection collection = getSubject().getPrincipals();

        Assert.assertEquals(2,collection.asList().size());
    }
    @Test
    public void testFirstSuccessStrategy(){
        login("classpath:test/test-shiro-FisrtSucessfulStrategy.ini","zhang","123");
        PrincipalCollection collection = getSubject().getPrincipals();
        System.out.println(collection.getPrimaryPrincipal());
        Assert.assertEquals(1, collection.asList().size());
    }
    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }
}
