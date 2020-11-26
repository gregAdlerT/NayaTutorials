package lesson06real_spring.hw_inject_random_string.soldiers.config;

import lesson04design_patterns.heroes.RandomUtils;
import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Greg Adler
 */
public class GenerateObjectsAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map<String,List<Object>>result=new HashMap<>();
    
    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Reflections scanner = new Reflections("lesson_06_real_spring");
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            GenerateObjects annotation = field.getAnnotation(GenerateObjects.class);
            if (annotation!=null){
                fillMap(scanner, annotation);
                field.setAccessible(true);
                field.set(bean,result);
            }
        }

        return bean;
    }

    private void fillMap(Reflections scanner, GenerateObjects annotation) throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        int amount = annotation.amount();
        Class<?> clazz = annotation.clazz();
        List<Class<?>> classes = scanner.getSubTypesOf((Class<Object>) clazz).stream().collect(Collectors.toList());
        for (int i = 0; i < amount; i++) {
            Class<?> aClass = classes.get(RandomUtils.getRandomInRange(0, classes.size() - 1));
            Object object = aClass.getDeclaredConstructor().newInstance();
            String simpleName = aClass.getSimpleName();
            addToMap(object, simpleName);
        }
    }

    private void addToMap(Object object, String simpleName) {
        if (result.containsKey(simpleName)) {
            result.get(simpleName).add(object);
        }else {
            ArrayList<Object> list = new ArrayList<>();
            list.add(object);
            result.put(simpleName, list);
        }
    }
}
