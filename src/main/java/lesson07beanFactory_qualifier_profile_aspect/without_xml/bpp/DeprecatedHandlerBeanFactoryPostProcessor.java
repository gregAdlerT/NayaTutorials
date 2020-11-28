package lesson07beanFactory_qualifier_profile_aspect.without_xml.bpp;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Greg Adler
 */
@Component
public class DeprecatedHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @SneakyThrows
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Iterator<String> beanNamesIterator = configurableListableBeanFactory.getBeanNamesIterator();
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanDefinitionName);
            String beanClassName = beanDefinition.getBeanClassName();
            Class<?> aClass = Class.forName(beanClassName);
            boolean isPreDestroy = Arrays.stream(aClass.getDeclaredMethods()).anyMatch(m -> m.isAnnotationPresent(PreDestroy.class));
            boolean isPrototype = beanDefinition.isPrototype();
            String destroyMethodName = beanDefinition.getDestroyMethodName();
            if (isPrototype && (destroyMethodName != null || isPreDestroy)) {
                throw new IllegalStateException("Build failed cause: Class" + beanClassName + " have scope prototype and destroy method");
            }
        }

//        beanNamesIterator.forEachRemaining((name)->{
//            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(name);
//            boolean isPrototype = beanDefinition.isPrototype();
//            String destroyMethodName = beanDefinition.getDestroyMethodName();
//            if (isPrototype && destroyMethodName!=null){
//                String className = beanDefinition.getBeanClassName();
//                throw new IllegalStateException("Build failed cause: Class"+className+" have scope prototype and destroy method");
//            }
//        });

    }
}