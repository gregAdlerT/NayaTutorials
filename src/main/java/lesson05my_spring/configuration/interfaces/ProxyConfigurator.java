package lesson05my_spring.configuration.interfaces;

/**
 * @author Greg Adler
 */
public interface ProxyConfigurator {
    <T>Object wrapWithProxy(Object obj, Class<T> clazz);
}
