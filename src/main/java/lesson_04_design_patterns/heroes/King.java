package lesson_04_design_patterns.heroes;

import lombok.Setter;

/**
 * @author Greg Adler
 */
public class King extends Hero {
    @Setter
    private Weapon weapon= new Sword();
    @Override
    protected int getInitialPower() {
        return RandomUtils.getRandomInRange(5,15);
    }

    @Override
    protected int getInitialHp() {
        return RandomUtils.getRandomInRange(5,15);
    }

    @Override
    public void kick(Hero enemy) {
        weapon.kick(this,enemy);
    }
}
