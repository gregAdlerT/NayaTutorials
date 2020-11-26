package lesson06real_spring.hw_inject_random_string.soldiers.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Greg Adler
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface GenerateObjects {
    Class<?>clazz();
    int amount();
}
