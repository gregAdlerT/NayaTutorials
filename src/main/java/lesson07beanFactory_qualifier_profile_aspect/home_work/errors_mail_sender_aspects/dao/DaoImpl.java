package lesson07beanFactory_qualifier_profile_aspect.home_work.errors_mail_sender_aspects.dao;

import lesson04design_patterns.heroes.RandomUtils;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Greg Adler
 */
@Repository
public class DaoImpl implements Dao {
    List<String>messages= Arrays.asList("Not found","Invalid data","Unauthorized");
   
    @Override
    public Object get() throws SQLException {
        String message = messages.get(RandomUtils.getRandomInRange(0, messages.size() - 1));
        throw new SQLException(message);
    }
}
