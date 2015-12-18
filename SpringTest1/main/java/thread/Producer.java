package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by wb-chenchaobin on 2015/12/18.
 */
public class Producer extends Thread{
    private BufferedReader reader;
    private Buffer buffer;
    public Producer(Buffer buffer) {
        this.buffer = buffer;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }
    void send(String s){
        buffer.send(s);
    }


    @Override
    public void run() {
        while (true){
            try {
                String line = reader.readLine();
                if(line!=null){
                    send(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
