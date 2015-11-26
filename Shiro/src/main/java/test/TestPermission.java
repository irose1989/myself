package test;

import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Test;

/**
 * Created by wb-chenchaobin on 2015/11/26.
 */
public class TestPermission extends BaseTest{
    @Test
    public void testPermission(){
        login("classpath:test/test-shiro-permission.ini", "zhang", "123");
        getSubject().isPermitted("user:delete");
    }
    @After
    public void afterDo(){
        ThreadContext.unbindSubject();
    }
}
