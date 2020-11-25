package lesson03design_patterns.mail_sender.service;

import lesson03design_patterns.mail_sender.mail_sender_third_impl.InjectableClass;

/**
 * @author Greg Adler
 */
@InjectableClass(id = 2)
public class EmailCallbackMailGen implements MailGenerator {
    @Override
    public String generateMail() {
        return "Bay";
    }
}
