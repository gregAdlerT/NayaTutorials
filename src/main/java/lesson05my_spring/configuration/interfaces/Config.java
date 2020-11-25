package lesson05my_spring.configuration.interfaces;

/**
 * @author Greg Adler
 */
public interface Config {
    <T> Class<T> getInterfaceImpl(Class<T> type);
}
