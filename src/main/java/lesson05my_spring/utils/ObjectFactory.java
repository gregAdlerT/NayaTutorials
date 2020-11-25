package lesson05my_spring.utils;

import lesson05my_spring.configuration.JavaConfig;
import lesson05my_spring.configuration.interfaces.Config;
import lesson05my_spring.configuration.interfaces.ObjectConfigurator;
import lesson05my_spring.configuration.interfaces.ObjectInitializer;
import lesson05my_spring.configuration.interfaces.ProxyConfigurator;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Greg Adler
 */
public class ObjectFactory {
    private static ObjectFactory instance=new ObjectFactory();
    private Config config=new JavaConfig();
    private List<ObjectConfigurator> configurators= new ArrayList<>();
    private List<ObjectInitializer> initializers= new ArrayList<>();
    private List<ProxyConfigurator> proxyConfigurators= new ArrayList<>();
    private Reflections scanner = new Reflections("lesson05my_spring");



    @SneakyThrows
    private ObjectFactory(){
        Set<Class<? extends ObjectConfigurator>> configClasses = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : configClasses) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
        Set<Class<? extends ObjectInitializer>> initClasses = scanner.getSubTypesOf(ObjectInitializer.class);
        for (Class<? extends ObjectInitializer> aClass : initClasses) {
            initializers.add(aClass.getDeclaredConstructor().newInstance());
        }
        Set<Class<? extends ProxyConfigurator>> proxyConfigClasses = scanner.getSubTypesOf(ProxyConfigurator.class);
        for (Class<? extends ProxyConfigurator> aClass : proxyConfigClasses) {
            proxyConfigurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }
    
    public static ObjectFactory getInstance(){
        return instance;
    }
    
    @SneakyThrows
    public <T> T createObject(Class<T> clazz){
        clazz = resolveImpl(clazz);
        T t = create(clazz);
        configure(t);
        init(t);
        t= wrapWithProxyIfNeeded(t,clazz);
        return t;
    }

    private <T> T wrapWithProxyIfNeeded(T t, Class<T> clazz) {
        for (ProxyConfigurator proxyConfigurator : proxyConfigurators) {
            t= (T) proxyConfigurator.wrapWithProxy(t,clazz);
        }
        return t;
    }

    private <T> void configure(T t) {
        configurators.forEach(c->c.configure(t));
    }

    private <T> void init(T t) {
        initializers.forEach(i->i.init(t));
    }

    private <T> T create(Class<T> clazz) throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        return clazz.getDeclaredConstructor().newInstance();
    }

    private <T> Class<T> resolveImpl(Class<T> clazz) {
        if (clazz.isInterface()){
            clazz=config.getInterfaceImpl(clazz);
            if (clazz==null){
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(clazz);
                if (classes.size()!=1){
                    throw new RuntimeException("0 more than one implementations of:"+clazz.getSimpleName()+" was found, please update your config");
                }
                clazz= (Class<T>) classes.iterator().next();
            }
        }
        return clazz;
    }
}
