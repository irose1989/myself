package event;

import org.springframework.context.ApplicationListener;

/**
 * Created by wb-chenchaobin on 2015/12/14.
 */
public class MailListener implements ApplicationListener<MailSendEvent> {
    public void onApplicationEvent(MailSendEvent mailSendEvent) {
        System.out.println("mailSendEvent：向"+mailSendEvent.getTo()+"发送完一封信");
    }
}
