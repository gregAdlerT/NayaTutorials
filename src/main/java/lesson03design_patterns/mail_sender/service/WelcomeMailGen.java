package lesson03design_patterns.mail_sender.service;

import lesson03design_patterns.mail_sender.mail_sender_third_impl.InjectableClass;

/**
 * @author Greg Adler
 */
@InjectableClass(id = 1)
public class WelcomeMailGen implements MailGenerator {
    @Override
    public String generateMail() {
        return "Hii";
    }
}
