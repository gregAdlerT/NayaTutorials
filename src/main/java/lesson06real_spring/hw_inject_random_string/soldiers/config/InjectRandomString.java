package lesson06real_spring.hw_inject_random_string.soldiers.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Greg Adler
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectRandomString {
    String[]values() default {"Lannister","Stark","Mormont","Targaryen"};
}
