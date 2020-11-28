package lesson08aspect.profiles_examples;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Greg Adler
 */
@Configuration
@PropertySource("classpath:dev.properties")
@Profile(ProfilesConstants.DEV)
//@ComponentScan("packages which contains beans only needed for dev, but not for production environment")
public class DevConfig {
}
