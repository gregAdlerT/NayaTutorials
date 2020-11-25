package lesson05my_spring.configuration.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Greg Adler
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectByType {
}
