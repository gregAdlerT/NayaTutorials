package lesson07beanFactory_qualifier_profile_aspect.home_work.distributionService_not_dynamic_injection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Greg Adler
 */
@Configuration
@ComponentScan
@EnableScheduling
public class Main {
    
    @Bean
    public Map<Integer,MailGenerator>services(List<MailGenerator>generators){
        return generators.stream().collect(Collectors.toMap(MailGenerator::getCode, Function.identity()));
    }
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
    }
}
