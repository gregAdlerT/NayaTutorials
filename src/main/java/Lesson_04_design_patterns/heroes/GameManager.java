package Lesson_04_design_patterns.heroes;

/**
 * @author Greg Adler
 */
public class GameManager {
    public void fight(Hero hero1,Hero hero2){
        while (hero1.isAlive() && hero2.isAlive()){
            hero1.kick(hero2);
            hero2.kick(hero1);
        }
        if (hero1.isAlive()){
            printWinner(hero1);
        }else {
            printWinner(hero2);
        }
    }

    private void printWinner(Hero hero) {
        System.out.println(hero.getClass().getSimpleName() + " is a winner");
    }
}
