package Lesson_04_design_patterns.heroes;

/**
 * @author Greg Adler
 */
public class Sword implements Weapon {
    @Override
    public void kick(Hero attacker, Hero defender) {
        int damage = RandomUtils.getRandomInRange(0, attacker.getPower());
        defender.decreaseHp(damage);
    }
}
