package lesson07beanFactory_qualifier_profile_aspect.home_work.distributionService_my_implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Greg Adler
 */
@Service
public class DistributionService {
    
    @Autowired
    private Map<String, MailGenerator> services;

    
    @Autowired
    MailDao repo;

    @Scheduled(fixedDelay = 300)
    public void sendMail(){
        int mailCode = repo.getMailCode();
        Integer code=mailCode;
        System.out.println(services.get(code.toString()).generateMail());
    }
}
