package lesson07beanFactory_qualifier_profile_aspect.refresh_prototype_in_singleton.proxy_mode_solution;

import lesson07beanFactory_qualifier_profile_aspect.refresh_prototype_in_singleton.ColorFrame;
import lombok.SneakyThrows;
import org.springframework.context.annotation.*;

import java.awt.*;

import static lesson04design_patterns.heroes.RandomUtils.*;

/**
 * @author Greg Adler
 */
@Configuration
@ComponentScan
public class MainConfigProxySolution {
    
    @Bean
    @Scope(value = "prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Color color(){
        return new Color(getRandomInRange(0,255),getRandomInRange(0,255),getRandomInRange(0,255));
    }

    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigProxySolution.class);
        while (true){
            context.getBean(ColorFrame.class).moveToRandomLocation();
            Thread.sleep(80);
        }
    }
}
