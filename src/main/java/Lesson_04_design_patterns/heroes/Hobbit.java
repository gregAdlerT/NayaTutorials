package Lesson_04_design_patterns.heroes;

/**
 * @author Greg Adler
 */
public class Hobbit extends Hero {
    @Override
    protected int getInitialPower() {
        return 0;
    }

    @Override
    protected int getInitialHp() {
        return 3;
    }

    @Override
    public void kick(Hero enemy) {
        cry();
    }

    private void cry() {
        System.out.println("Help!!!");
    }
}
