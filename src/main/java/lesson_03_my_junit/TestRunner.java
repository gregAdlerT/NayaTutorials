package lesson_03_my_junit;

import lombok.SneakyThrows;

import java.lang.reflect.Method;

/**
 * @author Greg Adler
 */
public class TestRunner {

    @SneakyThrows
    public void runAllTestsForClassByName(String name){
        Class<?> aClass = Class.forName(name);
        runAllTestsForClass(aClass);
    }
    
    @SneakyThrows
    public void runAllTestsForClass(Class<?> type){
        Object o = type.getDeclaredConstructor().newInstance();
        runAllTests(o);
    }
    
    @SneakyThrows
    public void runAllTests(Object obj){
        Method[] declaredMethods = obj.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().startsWith("test") || declaredMethod.isAnnotationPresent(MyTest.class)){
                declaredMethod.invoke(obj);
            }
        }
    }
}
