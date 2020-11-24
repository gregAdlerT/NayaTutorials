package Lesson_04_design_patterns.heroes_my_implementation.entities.intefaces;

import Lesson_04_design_patterns.heroes_my_implementation.entities.Hero;

/**
 * @author Greg Adler
 */
public interface HobbitKickStrategy extends KickStrategy {
    @Override
    default void applyStrategy(Hero... enemy){
        enemy[0].setHp(enemy[0].getHp()+1);
        System.out.println("AAA help!");
    }
}
