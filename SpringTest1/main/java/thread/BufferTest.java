package thread;

import org.junit.Test;
import thread.polling.PollingBuffer;


/**
 * Created by wb-chenchaobin on 2015/12/18.
 */
public class BufferTest {
    @Test
    public void testPollingBuffer(){
        Buffer buffer = new PollingBuffer();
        Producer producer = new Producer(buffer);
        producer.start();
        Consumer consumer = new Consumer(buffer);
        consumer.start();
    }
}
