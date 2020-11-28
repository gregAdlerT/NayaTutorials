package lesson07beanFactory_qualifier_profile_aspect.profiles_examples;

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
public class Confi {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", ProfilesConstants.DEV);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Confi.class);
        
    }
}
