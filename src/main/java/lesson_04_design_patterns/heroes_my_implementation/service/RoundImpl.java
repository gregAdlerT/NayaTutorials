package lesson_04_design_patterns.heroes_my_implementation.service;

import lesson_04_design_patterns.heroes_my_implementation.entities.Hero;

/**
 * @author Greg Adler
 */
public class RoundImpl implements Round {
    
    @Override
    public Hero fight(Hero warrior1, Hero warrior2) {
        warrior1.kick(warrior2);
        if (!warrior2.isAlive()){
            return warrior1;
        }
        warrior2.kick(warrior1);
        if (!warrior1.isAlive()){
            return warrior2;
        }
        return null;
    }
}
