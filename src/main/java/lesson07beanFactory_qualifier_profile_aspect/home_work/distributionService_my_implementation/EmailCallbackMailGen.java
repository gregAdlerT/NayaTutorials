package lesson07beanFactory_qualifier_profile_aspect.home_work.distributionService_my_implementation;

import org.springframework.stereotype.Component;

/**
 * @author Greg Adler
 */
@Component("1")
public class EmailCallbackMailGen implements MailGenerator {
    @Override
    public String generateMail() {
        return "Bay";
    }


}
