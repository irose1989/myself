package thread;

/**
 * Created by wb-chenchaobin on 2015/12/18.
 */
public interface Buffer {
    public void send(String s);
    public String receive();
}
