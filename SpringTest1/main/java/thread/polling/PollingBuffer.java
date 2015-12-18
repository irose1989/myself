package thread.polling;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import thread.Buffer;

/**
 * Created by wb-chenchaobin on 2015/12/18.
 */
public class PollingBuffer implements Buffer {
    private String line;
    public void send(String s) {
        while (line!=null){
            pause(1);
        }
        line=s;
    }

    public String receive() {
        while(line ==null){
            pause(1);
        }
        String s = line;
        line = null;
        return s;
    }
    void pause(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
