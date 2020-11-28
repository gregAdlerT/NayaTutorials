package lesson08aspect.profiles_examples;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Greg Adler
 */
@Configuration
@PropertySource("classpath:prod.properties")
@Profile(ProfilesConstants.PROD)
//@ComponentScan("packages which contains beans only needed for production, but not for dev environment")
public class ProdConfig {
}
