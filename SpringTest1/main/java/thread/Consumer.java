package thread;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by wb-chenchaobin on 2015/12/18.
 */
public class Consumer  extends Thread{
    private BufferedWriter writer;
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
        this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public String receive() {
        return  buffer.receive();
    }

    @Override
    public void run() {
        while(true){
            String line = receive();
            if(line!=null){
                try {
                    writer.write(line);
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
