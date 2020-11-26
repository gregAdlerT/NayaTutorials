package lesson06real_spring.hw_inject_random_string.bpp;

import lesson05my_spring.configuration.annotation_processors.InjectRandomIntAnnotationObjectConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Greg Adler
 */
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {
    private InjectRandomIntAnnotationObjectConfigurator objectConfigurator =new InjectRandomIntAnnotationObjectConfigurator();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        objectConfigurator.configure(bean);
        return bean;
    }
}
