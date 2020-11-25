package lesson05my_spring.configuration.annotation_processors;

import lesson05my_spring.configuration.annotations.InjectByType;
import lesson05my_spring.configuration.interfaces.ObjectConfigurator;
import lesson05my_spring.utils.ObjectFactory;
import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author Greg Adler
 */
public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {
    @SneakyThrows
    @Override
    public void configure(Object obj) {
        Set<Field> fields = ReflectionUtils.getAllFields(obj.getClass(), field -> field.isAnnotationPresent(InjectByType.class));
        for (Field field : fields) {
            field.setAccessible(true);
            Object object = ObjectFactory.getInstance().createObject(field.getType());
            field.set(obj,object);
        }
                
    }
}
