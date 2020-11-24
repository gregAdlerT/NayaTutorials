package lesson_04_design_patterns.heroes_my_implementation.utils;

import java.util.Random;

/**
 * @author Greg Adler
 */
public class RandomUtils {
    private static Random random=new Random();
    public static int getRandomInRange(int min, int max){
        return random.ints(min, max+1).findAny().getAsInt();
    }
    
}
