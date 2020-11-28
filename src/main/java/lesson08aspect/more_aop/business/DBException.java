package lesson08aspect.more_aop.business;

/**
 * @author Greg Adler
 */
public class DBException extends RuntimeException {
    public DBException(String message) {
        super(message);
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}
