package lesson07beanFactory_qualifier_profile_aspect.home_work.distributionService_patternt_registery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Greg Adler
 */
@Service
public class DistributionService {
    
    private Map<Integer, MailGenerator> services=new HashMap<>();
    
    @Autowired
    MailDao repo;
    
    public void register(int code, MailGenerator mailGenerator){
        if (services.containsKey(code)){
            throw new IllegalStateException("Code: "+code+" already in use");
        }
        services.put(code,mailGenerator);
    }

    @Scheduled(fixedDelay = 3000)
    public void sendMail(){
        int mailCode = repo.getMailCode();
        Integer code=mailCode;
        if (!services.containsKey(code)){
            throw new UnsupportedOperationException("Code:"+" unsupported yet");
        }
        System.out.println(services.get(code).generateMail());
    }
}
