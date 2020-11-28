package lesson08aspect.more_aop;

import lesson08aspect.more_aop.business.SomeService;
import org.springframework.context.annotation.*;

/**
 * @author Greg Adler
 */
@Configuration
@ComponentScan
@ImportResource("classpath:some_service_context.xml")
@PropertySource("classpath:mail.properties")
@EnableAspectJAutoProxy
public class SomeServiceConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SomeServiceConfig.class);
        SomeService bean = context.getBean(SomeService.class);
        try {
            bean.work();
        } catch (Exception e) {
            System.out.println("была проблемма, но мы решаем");
        }
    }
}
