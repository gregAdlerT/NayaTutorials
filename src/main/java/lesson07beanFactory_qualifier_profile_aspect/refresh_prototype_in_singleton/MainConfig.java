package lesson07beanFactory_qualifier_profile_aspect.refresh_prototype_in_singleton;

import lombok.SneakyThrows;
import org.springframework.context.annotation.*;

import java.awt.*;

import static lesson04design_patterns.heroes.RandomUtils.*;

/**
 * @author Greg Adler
 */
@Configuration
@ComponentScan
public class MainConfig {
    
    @Bean
    @Scope(value = "twoSeconds",proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Color color(){
        return new Color(getRandomInRange(0,255),getRandomInRange(0,255),getRandomInRange(0,255));
    }

    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        while (true){
            context.getBean(ColorFrame.class).moveToRandomLocation();
            Thread.sleep(80);
        }
    }
}
