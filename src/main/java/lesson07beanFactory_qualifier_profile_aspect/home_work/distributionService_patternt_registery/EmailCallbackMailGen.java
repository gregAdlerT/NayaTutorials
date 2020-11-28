package lesson07beanFactory_qualifier_profile_aspect.home_work.distributionService_patternt_registery;

import org.springframework.stereotype.Component;

/**
 * @author Greg Adler
 */
@Component
public class EmailCallbackMailGen implements MailGenerator {
    @Override
    public String generateMail() {
        return "Bay";
    }

    @Override
    public int getCode() {
        return 1;
    }


}
