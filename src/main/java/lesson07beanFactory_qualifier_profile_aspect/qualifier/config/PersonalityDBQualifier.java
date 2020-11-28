package lesson07beanFactory_qualifier_profile_aspect.qualifier.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Greg Adler
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Repository
@Autowired
public @interface PersonalityDBQualifier {
    DBType type();
}
