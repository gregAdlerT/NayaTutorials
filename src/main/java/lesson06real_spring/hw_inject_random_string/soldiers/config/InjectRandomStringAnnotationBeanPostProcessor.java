package lesson06real_spring.hw_inject_random_string.soldiers.config;

import lesson04design_patterns.heroes.RandomUtils;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

/**
 * @author Greg Adler
 */
public class InjectRandomStringAnnotationBeanPostProcessor implements BeanPostProcessor {
    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            InjectRandomString annotation = field.getAnnotation(InjectRandomString.class);
            if (annotation!=null){
                String[] values = annotation.values();
                String value = values[RandomUtils.getRandomInRange(0, values.length - 1)];
                field.setAccessible(true);
                field.set(bean,value);
            }
        }

        return bean;
    }
}
