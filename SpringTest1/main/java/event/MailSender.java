package event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by wb-chenchaobin on 2015/12/14.
 */
public class MailSender implements ApplicationContextAware {
    private ApplicationContext ac;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ac = applicationContext;
    }
    public void publish(String to){
        System.out.println("模拟发送邮件");
        MailSendEvent event = new MailSendEvent(ac,to);
        ac.publishEvent(event);
    }
}
