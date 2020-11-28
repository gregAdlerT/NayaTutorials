package lesson07beanFactory_qualifier_profile_aspect.home_work.distributionService_patternt_registery;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Greg Adler
 */
@Configuration
@ComponentScan
@EnableScheduling
public class Main {
    
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
    }
}
