package lesson07beanFactory_qualifier_profile_aspect.home_work.distributionService_patternt_registery;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Greg Adler
 */
public interface MailGenerator {
    String generateMail();
    int getCode();
    
    @Autowired
    default void registerMySelf(DistributionService distributionService){
        distributionService.register(getCode(),this);
    };
}
