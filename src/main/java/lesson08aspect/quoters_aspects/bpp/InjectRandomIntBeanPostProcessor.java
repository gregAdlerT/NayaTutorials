package lesson08aspect.quoters_aspects.bpp;

import lesson05my_spring.configuration.annotation_processors.InjectRandomIntAnnotationObjectConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Greg Adler
 */
@Component
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {
    private InjectRandomIntAnnotationObjectConfigurator objectConfigurator =new InjectRandomIntAnnotationObjectConfigurator();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        objectConfigurator.configure(bean);
        return bean;
    }
}
