package lesson_04_design_patterns.heroes_my_implementation.entities.intefaces;

import lesson_04_design_patterns.heroes_my_implementation.entities.Hero;

/**
 * @author Greg Adler
 */
public interface ElfKickStrategy extends KickStrategy {
    @Override
    default void applyStrategy(Hero... enemy){
        if(enemy[0].getPower()<enemy[1].getPower() || enemy[0].getPower()<0){
            enemy[0].setHp(0);
            System.out.println("Elf kicked "+enemy[0].getClass().getSimpleName()+" and kill him");
        }else {
            enemy[0].setPower(enemy[0].getPower()-1);
            System.out.println("Elf kicked "+enemy[0].getClass().getSimpleName()+" and damaged his power");
        }
    }
}
