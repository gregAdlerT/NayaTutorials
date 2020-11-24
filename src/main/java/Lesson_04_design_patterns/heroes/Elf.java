package Lesson_04_design_patterns.heroes;

/**
 * @author Greg Adler
 */
public class Elf extends Hero {
    @Override
    protected int getInitialPower() {
        return 10;
    }

    @Override
    protected int getInitialHp() {
        return 10;
    }

    @Override
    public void kick(Hero enemy) {
        if (enemy.getPower()<getPower()){
            die();
        }else {
            enemy.decreasePower(1);
        }
    }
}
