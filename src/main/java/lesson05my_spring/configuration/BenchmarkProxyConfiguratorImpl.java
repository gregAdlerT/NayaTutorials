package lesson05my_spring.configuration;

import lesson05my_spring.configuration.annotations.Benchmark;
import lesson05my_spring.configuration.interfaces.ProxyConfigurator;
import lesson05my_spring.mbean.BenchmarkToggle;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Greg Adler
 */
public class BenchmarkProxyConfiguratorImpl implements ProxyConfigurator {
    private BenchmarkToggle benchmarkToggle=new BenchmarkToggle();
    @Override
    public <T> Object wrapWithProxy(Object obj, Class<T> clazz) {
        if (clazz.isAnnotationPresent(Benchmark.class) ||
                Arrays.stream(clazz.getDeclaredMethods()).anyMatch(m->m.isAnnotationPresent(Benchmark.class))) {
            if (clazz.getInterfaces().length==0){
                return Enhancer.create(clazz, new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                        return invocationHandler(method, args, (Class<T>) clazz, obj);
                    }
                });
            }
            return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), (proxy, method, args) -> {
//                String name = clazz.getName();
//                Class<?>[] parameterTypes = method.getParameterTypes();
//                Method classMethod= clazz.getMethod(name,parameterTypes);
                return invocationHandler(method, args, clazz, obj);
            });
        }
        return obj;
    }

    private <T> Object invocationHandler(Method method, Object[] args, Class<T> clazz, Object obj) throws IllegalAccessException, InvocationTargetException {
        Method classMethod = Arrays.stream(clazz.getMethods()).filter(m -> isEquals(m, method)).findAny().get();

        if (benchmarkToggle.isEnable() && 
                (clazz.isAnnotationPresent(Benchmark.class) || 
                classMethod.isAnnotationPresent(Benchmark.class))) {
            System.out.println("****Benchmark for method:" + method.getName() + "started");
            long start = System.nanoTime();
            Object resValue = method.invoke(obj, args);
            long end = System.nanoTime();
            System.out.println("Result time: " + (end - start));
            System.out.println("****Benchmark for method:" + method.getName() + "finished");
            return resValue;
        } else {
            return method.invoke(obj, args);
        }
    }

    private boolean isEquals (Method m, Method method) {
        if (!m.getName().equals(method.getName()))return false;
        Class<?>[] parameterTypes = m.getParameterTypes();
        Class<?>[] parameterTypes1 = method.getParameterTypes();
        if (parameterTypes.length!=parameterTypes1.length)return false;
        for (int i = 0; i < parameterTypes1.length; i++) {
            if (!parameterTypes1[i].equals(parameterTypes[i]))return false;
        }
        return true;
    }
}
