package lesson07beanFactory_qualifier_profile_aspect.qualifier;

import lesson07beanFactory_qualifier_profile_aspect.qualifier.entities.PersonEntity;
import lesson07beanFactory_qualifier_profile_aspect.qualifier.services.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Greg Adler
 */
@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        
        
        PersonService service=context.getBean(PersonService.class);
        for (int i = 0; i < 10; i++) {
            service.add(new PersonEntity(i,"name"+i,"secondName"+i));
        }
    }
}
