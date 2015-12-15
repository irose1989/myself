package AopTest.helloWorld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wb-chenchaobin on 2015/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:aopTest/spring_aop.xml"})
public class HelloWorldTest {
    @Autowired
//    @Qualifier("helloWorld")
    private IHelloWorldService helloWorldService;
    @Test
    public void testHello(){
        helloWorldService.sayHello("chen");
    }
    @Test
    public void testAfter(){
        helloWorldService.afterReturn("yes");
    }
    @Test
    public void testException(){
        helloWorldService.afterThrow();
    }
    @Test
    public void testAround(){
        helloWorldService.testAround("hi");
    }
}
