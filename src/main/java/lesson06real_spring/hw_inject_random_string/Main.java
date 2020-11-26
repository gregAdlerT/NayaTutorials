package lesson06real_spring.hw_inject_random_string;

import lesson06real_spring.hw_inject_random_string.soldiers.service.Army;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Greg Adler
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextHW.xml");
        context.getBean(Army.class).attack();
//        Soldier soldier = context.getBean(Soldier.class);
//        System.out.println(soldier);
        context.close();
    }
}
