package lesson04design_patterns.heroes_my_implementation.entities.intefaces;

import lesson04design_patterns.heroes_my_implementation.entities.Hero;

/**
 * @author Greg Adler
 */
@FunctionalInterface
public interface KickStrategy {
    void applyStrategy(Hero... enemy);
}
