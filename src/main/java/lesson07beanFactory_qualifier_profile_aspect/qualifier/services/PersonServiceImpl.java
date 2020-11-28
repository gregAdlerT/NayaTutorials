package lesson07beanFactory_qualifier_profile_aspect.qualifier.services;

import lesson07beanFactory_qualifier_profile_aspect.qualifier.config.DBType;
import lesson07beanFactory_qualifier_profile_aspect.qualifier.config.PersonalityDBQualifier;
import lesson07beanFactory_qualifier_profile_aspect.qualifier.dao.CRUDRepository;
import lesson07beanFactory_qualifier_profile_aspect.qualifier.entities.PersonEntity;
import org.springframework.stereotype.Service;

/**
 * @author Greg Adler
 */
@Service
public class PersonServiceImpl implements PersonService {
    
    @PersonalityDBQualifier(type = DBType.ORACLE)
    private CRUDRepository backupDao;
    @PersonalityDBQualifier(type = DBType.MONGO)
    private CRUDRepository prod;


    @Override
    public PersonEntity add(PersonEntity person) {
        backupDao.add(person);
        prod.add(person);
        return person;
    }

    @Override
    public PersonEntity update(PersonEntity person) {
        backupDao.update(person);
        prod.update(person);
        return person;
    }

    @Override
    public PersonEntity delete(long id) {
        PersonEntity person = (PersonEntity) backupDao.deleteById(id);
        prod.deleteById(id);
        return person;
    }

    @Override
    public PersonEntity get(long id) {
        PersonEntity person = (PersonEntity) prod.getById(id);
        return person;
    }
}
