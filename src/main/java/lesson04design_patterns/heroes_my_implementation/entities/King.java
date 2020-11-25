package lesson04design_patterns.heroes_my_implementation.entities;

import lesson04design_patterns.heroes_my_implementation.entities.intefaces.KnightKickStrategy;


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
