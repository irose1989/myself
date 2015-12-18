package thread.ABC;

import java.util.concurrent.*;

/**
 * Created by wb-chenchaobin on 2015/12/18.
 */
public class ABCTest2 {
    public static void main(String[] args) {
        BlockingDeque queue = new LinkedBlockingDeque();
        queue.add("A");
        queue.add("B");
        queue.add("C");
        while (true){
            try {
                String info = (String) queue.take();
                System.out.print(info);
                queue.add(info);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
