package lesson05my_spring.configuration.annotation_processors;

import lesson04design_patterns.heroes.RandomUtils;
import lesson05my_spring.configuration.annotations.InjectRandomInt;
import lesson05my_spring.configuration.interfaces.ObjectConfigurator;
import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author Greg Adler
 */
public class InjectRandomIntAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object obj) {
        Set<Field> fields = ReflectionUtils.getAllFields(obj.getClass(), field -> field.isAnnotationPresent(InjectRandomInt.class));
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            int num= RandomUtils.getRandomInRange(annotation.min(),annotation.max());
            field.setAccessible(true);
            field.set(obj,num);
        }
    }
}
