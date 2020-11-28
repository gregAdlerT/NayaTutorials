package lesson07beanFactory_qualifier_profile_aspect.qualifier.dao;

import org.springframework.stereotype.Repository;

/**
 * @author Greg Adler
 */
@Repository
public interface CRUDRepository<U,T> {
    T add(T obj);
    T update(T obj);
    T deleteById(U id);
    T getById(U id);
}
