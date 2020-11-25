package lesson04design_patterns.heroes_my_implementation.entities;

import lesson04design_patterns.heroes_my_implementation.entities.intefaces.HobbitKickStrategy;

/**
 * @author Greg Adler
 */
public class Hobbit extends Hero implements HobbitKickStrategy {

    public Hobbit(int power, int hp) {
        super(power, hp);
    }

    @Override
    public void kick(Hero enemy) {
        applyStrategy();
    }

}
