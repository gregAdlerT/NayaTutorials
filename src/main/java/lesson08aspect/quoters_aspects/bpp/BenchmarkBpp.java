package lesson08aspect.quoters_aspects.bpp;

import lesson05my_spring.configuration.BenchmarkProxyConfiguratorImpl;
import lesson05my_spring.configuration.annotations.Benchmark;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Greg Adler
 */
@Component
public class BenchmarkBpp implements BeanPostProcessor {
    private Map<String,Class>map=new HashMap<>();
    private BenchmarkProxyConfiguratorImpl proxyConfigurator =new BenchmarkProxyConfiguratorImpl();
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Benchmark.class)){
            map.put(beanName,bean.getClass());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = map.get(beanName);
        if (aClass!=null) {
            Object proxy = proxyConfigurator.wrapWithProxy(bean, aClass);
            return proxy;
        }
        return bean;
    }
}
