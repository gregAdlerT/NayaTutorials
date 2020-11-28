package lesson07beanFactory_qualifier_profile_aspect.home_work.errors_mail_sender_aspects.service;

import lesson07beanFactory_qualifier_profile_aspect.home_work.errors_mail_sender_aspects.aspects.MyDeprecated;
import lesson07beanFactory_qualifier_profile_aspect.home_work.errors_mail_sender_aspects.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author Greg Adler
 */
@Service
public class DBService {
    @Autowired
    Dao repo;
    @MyDeprecated
    public void get() throws SQLException {
        repo.get();
    }
    
}
