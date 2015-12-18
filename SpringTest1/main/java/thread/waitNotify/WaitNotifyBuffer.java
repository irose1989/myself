package thread.waitNotify;

import thread.Buffer;

/**
 * Created by wb-chenchaobin on 2015/12/18.
 */
public class WaitNotifyBuffer implements Buffer{
    private String line;
    public synchronized void send(String s) {
        if(line != null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        line = s;
        notify();
    }

    public synchronized String receive() {
        if(line == null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String s = line ;
        line = null;
        notify();
        return s;
    }
}
