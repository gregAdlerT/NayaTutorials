package lesson03design_patterns.mail_sender.mail_sender_third_impl;

import lombok.SneakyThrows;
import lesson03design_patterns.mail_sender.service.MailGenerator;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Greg Adler
 */
public class InjectableClassProcessor {
    private Reflections scanner=new Reflections("lesson_03_design_patterns");
    
    private static int getId(Class<? extends MailGenerator> clazz){
        return clazz.getAnnotation(InjectableClass.class).id();
    }

    @SneakyThrows
    private static MailGenerator getNewInstance(Class<? extends MailGenerator> clazz){
        return clazz.getDeclaredConstructor().newInstance();
    }
    
    private static boolean isAnnotationPresent(Class<? extends MailGenerator> clazz){
        InjectableClass annotation = clazz.getAnnotation(InjectableClass.class);
        if (annotation==null){
          throw new IllegalStateException("Class:"+clazz.getSimpleName()+" need use annotation InjectableClass()" );
        }
        return true;
    }
    
    public Map<Integer,MailGenerator> process(Class clazz){
        Set <Class<? extends MailGenerator >>set = scanner.getSubTypesOf(clazz);
        return set.stream()
                .filter(c->!Modifier.isAbstract(c.getModifiers()))
                .filter(InjectableClassProcessor::isAnnotationPresent)
                .collect(Collectors.toMap(InjectableClassProcessor::getId,InjectableClassProcessor::getNewInstance));
//        Map<Integer,MailGenerator>res=new HashMap<>();
//        set.stream()
//                .filter(c->!Modifier.isAbstract(c.getModifiers()))
//                .forEach(c->{
//                    try {
//                        InjectableClass annotation = c.getAnnotation(InjectableClass.class);
//                        if (annotation==null){
//                            throw new IllegalStateException("Class:"+c.getSimpleName()+" need use annotation InjectableClass()" );
//                        }
//                        int id = annotation.id();
//                        if (!res.containsKey(id)){
//                            MailGenerator mailGenerator = c.getDeclaredConstructor().newInstance();
//                            res.put(id,mailGenerator);
//                        }else {
//                            throw new IllegalArgumentException("Id:"+id+" of class:"+c.getSimpleName()+
//                                    " already in use by class:"+res.get(id).getClass().getSimpleName());
//                        }
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
//                });
//          return res;              
    }
    
}
