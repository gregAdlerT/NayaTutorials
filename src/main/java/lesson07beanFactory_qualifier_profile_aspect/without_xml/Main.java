package lesson07beanFactory_qualifier_profile_aspect.without_xml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Greg Adler
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println();
        context.close();
        
    }
}
