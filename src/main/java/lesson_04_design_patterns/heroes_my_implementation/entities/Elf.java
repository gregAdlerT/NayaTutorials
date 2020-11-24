package lesson_04_design_patterns.heroes_my_implementation.entities;

import lesson_04_design_patterns.heroes_my_implementation.entities.intefaces.ElfKickStrategy;


/**
 * @author Greg Adler
 */
public class Elf extends Hero implements ElfKickStrategy {

    public Elf(int power, int hp) {
        super(power, hp);
    }

    @Override
    public void kick(Hero enemy) {
        applyStrategy(enemy,this);
    }
}
