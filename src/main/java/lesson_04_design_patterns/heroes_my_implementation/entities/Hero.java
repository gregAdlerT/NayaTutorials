package lesson_04_design_patterns.heroes_my_implementation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Greg Adler
 */
@AllArgsConstructor
@Getter
@Setter
public  class Hero {
    private int power;
    private int hp;
    
    public void kick(Hero enemy){
        
    }
    public  boolean isAlive(){
        return hp>0;
    }
}
