package lesson07beanFactory_qualifier_profile_aspect.home_work.distributionService_my_implementation;

import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * @author Greg Adler
 */
@Repository
public class MailDao {
    private static final int AMOUNT_SERVICES = 2;
    private static Random random =new Random();
    public int getMailCode(){
        return random.nextInt(AMOUNT_SERVICES)+1;
    }
}
