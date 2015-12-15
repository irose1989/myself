package AopTest.helloWorld;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by wb-chenchaobin on 2015/12/15.
 */
public class HelloWorldAspect {
    public void beforeHello(String text){
        System.out.println("======before   text："+text);
    }
    public void afterHello(String text){
        System.out.println("======after" +text);
    }
    public void returnTest(Object o){
        System.out.println("======afterReturn 后："+o);
    }
    public void afterException(){
        System.out.println("after-exception====:");
    }

    public void testAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("testAround 前");
//        pjp.proceed(new Object[]{"heihei"});
        pjp.proceed();
        System.out.println("testAround 后");
    }
}
