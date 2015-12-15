package AopTest.helloWorld;

/**
 * Created by wb-chenchaobin on 2015/12/15.
 */
public class HelloWorldAspect {
    public void beforeHello(String to){
        System.out.println("======before   to："+to);
    }
    public void afterHello(){
        System.out.println("======after");
    }
}
