package Lesson_04_design_patterns.heroes_my_implementation;

import Lesson_04_design_patterns.heroes_my_implementation.entities.*;
import Lesson_04_design_patterns.heroes_my_implementation.service.Round;
import Lesson_04_design_patterns.heroes_my_implementation.service.RoundImpl;
import Lesson_04_design_patterns.heroes_my_implementation.utils.RandomUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Greg Adler
 */
public class BattleAppl {
    private static final int WARRIOR_AMOUNT = 20;
    private static Map<Integer,List<Hero>>warriors=new HashMap<>();
    private static Round round=new RoundImpl();

    public static void main(String[] args) {
        warriors.put(0, getHobbits(WARRIOR_AMOUNT/4));
        warriors.put(1,  getElfs(WARRIOR_AMOUNT/4));
        warriors.put(2,  getKings(WARRIOR_AMOUNT/4));
        warriors.put(3,  getKnights(WARRIOR_AMOUNT/4));
        
        startFight();
    }

    private static void startFight() {
        Hero[] heroes = getRandomWarriors();
        Hero winner=fight(heroes[0],heroes[1]);
        backToWarriors(winner);
        if(warriors.entrySet().stream().filter(e->e.getValue().size()>0).collect(Collectors.toList()).size()>1){
            startFight();
        }
    }

    private static void backToWarriors(Hero winner) {
        if (winner.getClass().getSimpleName().equals("Elf")){
            warriors.get(1).add(winner);
        }else if (winner.getClass().getSimpleName().equals("King")){
            warriors.get(2).add(winner);
        }else if (winner.getClass().getSimpleName().equals("Knight")){
            warriors.get(3).add(winner);
        }else {
            throw new IllegalStateException("Check the logs Hobbit is win!!!");
        }
    }

    private static Hero fight(Hero hero1, Hero hero2) {
        System.out.println("warrior1: "+hero1.getClass().getSimpleName());
        System.out.println("warrior2: "+hero2.getClass().getSimpleName());
        int roundCounter=1;
        Hero winner=null;
        do {
            System.out.println("Round: "+roundCounter+" fight!");
            roundCounter++;
            winner= RandomUtils.getRandomInRange(0,1) ==1?round.fight(hero1,hero2):round.fight(hero2,hero1);
        }while (winner==null);

        System.out.println("And Winner is: "+winner.getClass().getSimpleName());
        System.out.println("+++++++++++++++++++++++++++++++++");
        return winner;
    }

    private static Hero[] getRandomWarriors() {
        Hero hero1=getRandomWarriorFromGroup(RandomUtils.getRandomInRange(0,3));
        Hero hero2=getRandomWarriorFromGroup(hero1 instanceof Hobbit?
                RandomUtils.getRandomInRange(1,3):RandomUtils.getRandomInRange(0,3));
       return new Hero[]{hero1,hero2};
    }

    private static Hero getRandomWarriorFromGroup(int ind) {
        List<Hero> group = warriors.get(ind);
        if (group.size()!=0) {
            Hero hero = group.get(RandomUtils.getRandomInRange(0,group.size()-1));
            warriors.get(ind).remove(hero);
            return hero;
        }
       return getRandomWarriorFromGroup(RandomUtils.getRandomInRange(1,3));
    }

    private static List<Hero> getElfs(int warriorAmount) {
        return Stream.iterate(0,num->num+1)
                .limit(warriorAmount)
                .map((num)->new Elf(10,10))
                .collect(Collectors.toList());
    }

    private static List<Hero> getKings(int warriorAmount) {
        int min=5;
        int max=15;
        return Stream.iterate(0,num->num+1)
                .limit(warriorAmount)
                .map((num)->new King(RandomUtils.getRandomInRange(min,max),RandomUtils.getRandomInRange(min,max)))
                .collect(Collectors.toList());
    }

    private static List<Hero> getKnights(int warriorAmount) {
        int min=2;
        int max=12;
        return Stream.iterate(0,num->num+1)
                .limit(warriorAmount)
                .map((num)->new Knight(RandomUtils.getRandomInRange(min,max),RandomUtils.getRandomInRange(min,max)))
                .collect(Collectors.toList());
    }

    private static List<Hero> getHobbits(int warriorAmount) {
       return Stream.iterate(0,num->num+1)
                .limit(warriorAmount)
                .map((num)->new Hobbit(0,3))
                .collect(Collectors.toList());
    }
}
