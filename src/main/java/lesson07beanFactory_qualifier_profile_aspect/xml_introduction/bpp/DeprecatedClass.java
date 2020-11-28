package lesson07beanFactory_qualifier_profile_aspect.xml_introduction.bpp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Greg Adler
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {
    Class<?>newClass();
}
