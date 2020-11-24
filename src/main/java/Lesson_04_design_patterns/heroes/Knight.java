package Lesson_04_design_patterns.heroes;

import lombok.Setter;

/**
 * @author Greg Adler
 */
public class Knight extends Hero {
    @Setter
    private Weapon weapon= new Sword();
    
    @Override
    protected int getInitialPower() {
        return RandomUtils.getRandomInRange(2,12);
    }

    @Override
    protected int getInitialHp() {
        return RandomUtils.getRandomInRange(2,12);
    }

    @Override
    public void kick(Hero enemy) {
        weapon.kick(this,enemy);
    }
}
