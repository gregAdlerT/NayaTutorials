package lesson08aspect.profiles_examples;

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
public class ProfileAppl {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", ProfilesConstants.DEV);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProfileAppl.class);
        
    }
}
