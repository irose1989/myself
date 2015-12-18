package thread.ABC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.FutureTask;

/**
 * Created by wb-chenchaobin on 2015/12/18.
 */
public class ABCTest {
    private static Map<String,Object>map = new HashMap<String, Object>();
    private static volatile String tag = "A";
    static {
        map.put("A","B");
        map.put("B","C");
        map.put("C","\n");
        map.put("\n","A");
    }
    public static void nextInfo(String key){
        tag = (String) map.get(key);
    }
    public static void main(String[] args) {
        new Thread(new PrintInfo("A")).start();
        new Thread(new PrintInfo("B")).start();
        new Thread(new PrintInfo("C")).start();
        new Thread(new PrintInfo("\n")).start();
    }
    private static class PrintInfo implements Runnable{
        private String info;

        public PrintInfo(String info) {
            this.info = info;
        }
        @Override
        public void run() {
            while(true){
                synchronized(tag){
                    if(info==tag){
                        System.out.print(info);
                        nextInfo(info);
                    }
                }
            }
        }
    }
}
