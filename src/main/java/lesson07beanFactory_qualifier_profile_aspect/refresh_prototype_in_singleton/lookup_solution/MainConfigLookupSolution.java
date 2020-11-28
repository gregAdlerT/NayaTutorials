package lesson07beanFactory_qualifier_profile_aspect.refresh_prototype_in_singleton.lookup_solution;

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
//@ImportResource("classpath:color_context.xml")
public class MainConfigLookupSolution {
    
    
    
    @Bean
    @Scope("prototype")
    public Color color(){
        return new Color(getRandomInRange(0,255),getRandomInRange(0,255),getRandomInRange(0,255));
    }
    
//    @Bean
//    public ColorFrame colorFrame(){
//        return new ColorFrame() {
//            @Override
//            protected Color getColorBean() {
//                return color();
//            }
//        };
//    }
    
    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigLookupSolution.class);
        while (true){
            context.getBean(ColorFrame.class).moveToRandomLocation();
            Thread.sleep(80);
        }
    }
}
