package Lesson_04_design_patterns.heroes_my_implementation.entities.intefaces;

import Lesson_04_design_patterns.heroes_my_implementation.entities.Hero;
import Lesson_04_design_patterns.heroes_my_implementation.utils.RandomUtils;

/**
 * @author Greg Adler
 */
public interface KnightKickStrategy extends KickStrategy {
    @Override
    default void applyStrategy(Hero... enemy){
        int kickPower = RandomUtils.getRandomInRange(0,enemy[0].getHp());
        enemy[0].setHp(enemy[0].getHp()-kickPower);
        System.out.println("Warrior kicked "+enemy[0].getClass().getSimpleName()+" and damage "+kickPower);
    }
}
