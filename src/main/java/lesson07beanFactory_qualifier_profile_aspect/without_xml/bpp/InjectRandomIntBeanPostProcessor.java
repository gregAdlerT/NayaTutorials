package lesson07beanFactory_qualifier_profile_aspect.without_xml.bpp;

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
