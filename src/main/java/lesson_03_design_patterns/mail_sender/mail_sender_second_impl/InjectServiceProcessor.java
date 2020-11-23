package lesson_03_design_patterns.mail_sender.mail_sender_second_impl;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.*;

/**
 * @author Greg Adler
 */
public class InjectServiceProcessor {
    
    @SneakyThrows
    public Object process(Class aClass){
        Class[] classes = getClasses("lesson_03_design_patterns");
        Object objResult=null;
        for (Class clazzFromContext : classes) {
            Field[] declaredFields = clazzFromContext.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(InjectServices.class)){
                    Map<Integer,Object>res=new HashMap<>();
                    objResult = clazzFromContext.getDeclaredConstructor().newInstance();
                    int implementationCounter=0;
                    for (Class clazz : classes) {
                        if (!Modifier.isAbstract(clazz.getModifiers())) {
                            Class[] interfaces = clazz.getInterfaces();
                            for (Class interfaceClass : interfaces) {
                                if (interfaceClass.equals(aClass)){
                                    implementationCounter++;
                                    Object instance = clazz.getDeclaredConstructor().newInstance();
                                    res.put(implementationCounter,instance);
                                }
                            }
                        }
                    }
                    field.setAccessible(true);
                    field.set(objResult,res);
                }
            }
        }
//        int implementationCounter=0;
//        for (Class clazz : classes) {
//            Class[] interfaces = clazz.getInterfaces();
//            for (Class interfaceClass : interfaces) {
//                if (interfaceClass.equals(aClass)){
//                    implementationCounter++;
//                    Object instance = clazz.getDeclaredConstructor().newInstance();
//                    res.put(implementationCounter,instance);
//                }
//            }
//        }
//        return res;
        return objResult;
    }

    private Class[] getClasses(String packageName)
        throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        Enumeration resources = classLoader.getResources(packageName);
        List<File> dirs = new ArrayList();
        while (resources.hasMoreElements()) {
            URL resource =(URL) resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes.toArray(new Class[classes.size()]);
    } 
    private List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}
