package lesson07beanFactory_qualifier_profile_aspect.home_work.errors_mail_sender_aspects.dao;

import java.sql.SQLException;

/**
 * @author Greg Adler
 */
public interface Dao {
    Object get() throws SQLException;
}
