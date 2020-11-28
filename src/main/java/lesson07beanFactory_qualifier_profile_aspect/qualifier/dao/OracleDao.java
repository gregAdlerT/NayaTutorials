package lesson07beanFactory_qualifier_profile_aspect.qualifier.dao;


import lesson07beanFactory_qualifier_profile_aspect.qualifier.config.DBType;
import lesson07beanFactory_qualifier_profile_aspect.qualifier.config.PersonalityDBQualifier;
import lesson07beanFactory_qualifier_profile_aspect.qualifier.entities.PersonEntity;

/**
 * @author Greg Adler
 */
@PersonalityDBQualifier(type = DBType.ORACLE)
public class OracleDao implements CRUDRepository<Long, PersonEntity> {
    @Override
    public PersonEntity add(PersonEntity personEntity) {
        System.out.println(personEntity+" successfully added to oracle");
        return personEntity;
    }

    @Override
    public PersonEntity update(PersonEntity personEntity) {
        System.out.println(personEntity+" successfully updated to oracle");
        return personEntity;
    }

    @Override
    public PersonEntity deleteById(Long id) {
        PersonEntity personEntity = new PersonEntity(1, "John", "oConnor");
        System.out.println(personEntity+" successfully removed from oracle");
        return personEntity;
    }

    @Override
    public PersonEntity getById(Long id) {
        PersonEntity personEntity = new PersonEntity(1, "John", "oConnor");
        System.out.println(personEntity+" successfully found in oracle");
        return personEntity;
    }
}
