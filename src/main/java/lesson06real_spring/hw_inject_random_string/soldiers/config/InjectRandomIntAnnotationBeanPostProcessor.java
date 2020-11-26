package lesson06real_spring.hw_inject_random_string.soldiers.config;

import lesson04design_patterns.heroes.RandomUtils;
import lesson05my_spring.configuration.annotations.InjectRandomInt;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

/**
 * @author Greg Adler
 */
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation!=null){
                int value = RandomUtils.getRandomInRange(annotation.min(), annotation.max());
                field.setAccessible(true);
                field.set(bean,value);
            }
        }

        return bean;
    }
}
