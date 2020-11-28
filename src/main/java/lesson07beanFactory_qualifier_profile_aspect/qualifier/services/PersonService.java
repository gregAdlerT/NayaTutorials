package lesson07beanFactory_qualifier_profile_aspect.qualifier.services;

import lesson07beanFactory_qualifier_profile_aspect.qualifier.entities.PersonEntity;

/**
 * @author Greg Adler
 */
public interface PersonService {
    PersonEntity add(PersonEntity person);
    PersonEntity update(PersonEntity person);
    PersonEntity delete(long id);
    PersonEntity get(long id);
}
