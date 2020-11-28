package lesson08aspect.more_aop.business;

import org.springframework.stereotype.Repository;

/**
 * @author Greg Adler
 */
@Repository
public class SomeDaoImpl implements SomeDao {
    @Override
    public void saveData() {
        System.out.println("trying to save........");
        throw new DBException("DBA");
    }
}
