package AopTest.helloWorld;

/**
 * Created by wb-chenchaobin on 2015/12/15.
 */
public class HelloWorldService implements IHelloWorldService {
    public void sayHello(String to) {
        System.out.println("============hello:"+to);
    }
}
