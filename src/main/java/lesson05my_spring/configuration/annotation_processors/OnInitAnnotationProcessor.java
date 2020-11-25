package lesson05my_spring.configuration.annotation_processors;

import lesson05my_spring.configuration.annotations.OnInit;
import lesson05my_spring.configuration.interfaces.ObjectInitializer;
import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author Greg Adler
 */
public class OnInitAnnotationProcessor implements ObjectInitializer {
    @SneakyThrows
    @Override
    public void init(Object obj) {
        Set<Method> allMethods = 
                ReflectionUtils.getAllMethods(obj.getClass(), method -> method.isAnnotationPresent(OnInit.class));
        for (Method method : allMethods) {
            method.invoke(obj);
        }
    }
}
