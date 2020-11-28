package lesson08aspect.quoters_aspects;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Greg Adler
 */
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class Config {
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer(){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setIgnoreResourceNotFound(true);
        configurer.setFileEncoding("utf-8");
        return configurer;
    }
}
