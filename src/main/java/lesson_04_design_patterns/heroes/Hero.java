package lesson_04_design_patterns.heroes;

import lombok.Data;

/**
 * @author Greg Adler
 */
@Data
public abstract class Hero {
    private int power;
    private int hp;
    
    public Hero(){
        power=getInitialPower();
        hp=getInitialHp();
    }

    protected abstract int getInitialPower();

    protected abstract int getInitialHp();
    
    public abstract void kick(Hero enemy);
    
    public boolean isAlive(){
        return hp>0;
    }
    
    public void die(){
        hp=0;
    }
    
    public void decreasePower(int delta){
        power-=delta;
    }
    
    public void decreaseHp( int delta){
        hp-=delta;
    }
}
