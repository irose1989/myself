package AopTest.helloWorld;

/**
 * Created by wb-chenchaobin on 2015/12/15.
 */
public interface IHelloWorldService {
    public void sayHello(String text);
    public boolean afterReturn(Object o);
    public void afterThrow();
    public void testAround(String text);
}
