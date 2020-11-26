package lesson06real_spring.hw_inject_random_string.soldiers;

import lesson06real_spring.hw_inject_random_string.soldiers.config.InjectRandomString;
import lesson05my_spring.configuration.annotations.InjectRandomInt;
import lombok.Data;

/**
 * @author Greg Adler
 */
@Data
public class Soldier {
    @InjectRandomInt(min = 18,max = 80)
    private int age;
    @InjectRandomString(values = {"Tywin","Edgard","Jaime","Jonah","Viserys"})
    private String name;
    @InjectRandomString
    private String secondName;
    
    public Soldier(){}
    
    public void fight(){};
    
//    public void setAge(String age){
//        System.out.println(age);
//    }
}
