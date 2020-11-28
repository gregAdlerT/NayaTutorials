package lesson07beanFactory_qualifier_profile_aspect.home_work.errors_mail_sender_aspects.aspects;

import org.springframework.stereotype.Component;

/**
 * @author Greg Adler
 */
@Component
public class MailSenderImpl implements MailSender {
    @Override
    public void send(String email, String message) {
        System.out.println("Sent to: "+email+" content: "+message);
    }
}
