package Lesson_04_design_patterns.heroes_my_implementation.entities;

import Lesson_04_design_patterns.heroes_my_implementation.entities.intefaces.KnightKickStrategy;


/**
 * @author Greg Adler
 */
public class King extends Hero implements KnightKickStrategy {

    public King(int power, int hp) {
        super(power, hp);
    }

    @Override
    public void kick(Hero enemy) {
        applyStrategy(enemy);
    }
}
