package chapter1.bean;

/**
 * Created by wb-chenchaobin on 2015/12/15.
 */
public class Singleton {
    private Singleton() {
    }
    private static class NewSingleton{
        private static final Singleton singleton = new Singleton();
    }
    public static  Singleton getSingleton(){
            return  NewSingleton.singleton;
    }
    private int count=0;
}
