package lesson_04_design_patterns.heroes;

import java.util.Random;

/**
 * @author Greg Adler
 */
public class RandomUtils {
    private static Random random=new Random();
    public static int getRandomInRange(int min, int max){
        return random.ints(min, max).findAny().getAsInt();
    }
}
