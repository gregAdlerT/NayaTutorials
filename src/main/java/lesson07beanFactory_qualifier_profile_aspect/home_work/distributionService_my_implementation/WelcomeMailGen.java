package lesson07beanFactory_qualifier_profile_aspect.home_work.distributionService_my_implementation;

import org.springframework.stereotype.Component;

/**
 * @author Greg Adler
 */
@Component("2")
public class WelcomeMailGen implements MailGenerator {
    @Override
    public String generateMail() {
        return "Hii";
    }

}
