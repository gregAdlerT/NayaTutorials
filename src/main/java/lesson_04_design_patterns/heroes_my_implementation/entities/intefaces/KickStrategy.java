package lesson_04_design_patterns.heroes_my_implementation.entities.intefaces;

import lesson_04_design_patterns.heroes_my_implementation.entities.Hero;

/**
 * @author Greg Adler
 */
@FunctionalInterface
public interface KickStrategy {
    void applyStrategy(Hero... enemy);
}
