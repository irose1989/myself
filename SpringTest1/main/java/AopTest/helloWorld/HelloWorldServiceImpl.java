package AopTest.helloWorld;

/**
 * Created by wb-chenchaobin on 2015/12/15.
 */
public class HelloWorldServiceImpl implements IHelloWorldService {
    public void sayHello(String text) {
        System.out.println("============hello:"+text);
    }

    public boolean afterReturn(Object object) {
        System.out.println("afterReturn中:"+object);
        return true;
    }

    public void afterThrow() {
        String s=null;
            System.out.println("异常前");
            s.split(",");
            System.out.println("出现异常");
    }

    public void testAround(String text) {
        System.out.println("testAround中:"+text);
    }
}
