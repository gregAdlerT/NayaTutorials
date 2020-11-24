package lesson_04_design_patterns.heroes_my_implementation.service;

import lesson_04_design_patterns.heroes_my_implementation.entities.Hero;

/**
 * @author Greg Adler
 */
public interface Round {
    Hero fight(Hero warrior1, Hero warrior2);
}
