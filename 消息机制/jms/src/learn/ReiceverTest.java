package learn;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by wb-chenchaobin on 2015/11/18.
 */
public class ReiceverTest {

    public static void main(String[] args) {
        reicever();

    }
    public static void reicever(){
        Connection connection=null;
        ActiveMQConnectionFactory factory;
        Session session;
        MessageConsumer consumer;
        Destination destination;
        factory = new ActiveMQConnectionFactory();
        try {
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE,Session.CLIENT_ACKNOWLEDGE);
            destination = session.createQueue("FirstQueue");
            consumer = session.createConsumer(destination);
            while (true){
                TextMessage message = (TextMessage) consumer.receive();
                System.out.println("ReiceverTest接收到："+message.getText());
            }
         } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
