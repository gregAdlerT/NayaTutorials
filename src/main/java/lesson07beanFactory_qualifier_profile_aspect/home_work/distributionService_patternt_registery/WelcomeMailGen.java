package lesson07beanFactory_qualifier_profile_aspect.home_work.distributionService_patternt_registery;

import org.springframework.stereotype.Component;

/**
 * @author Greg Adler
 */
@Component
public class WelcomeMailGen implements MailGenerator {
    @Override
    public String generateMail() {
        return "Hii";
    }

    @Override
    public int getCode() {
        return 2;
    }
}
