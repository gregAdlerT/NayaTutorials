package lesson07beanFactory_qualifier_profile_aspect.home_work.errors_mail_sender_aspects;

import lesson07beanFactory_qualifier_profile_aspect.home_work.errors_mail_sender_aspects.service.DBService;
import lombok.SneakyThrows;
import org.springframework.context.annotation.*;

/**
 * @author Greg Adler
 */
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class ErrorNotificationAppl {

    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ErrorNotificationAppl.class);
        context.getBean(DBService.class).get();
    }
}
