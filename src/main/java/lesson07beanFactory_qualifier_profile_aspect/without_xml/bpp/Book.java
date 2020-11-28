package lesson07beanFactory_qualifier_profile_aspect.without_xml.bpp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Greg Adler
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Component
public @interface Book {
}
