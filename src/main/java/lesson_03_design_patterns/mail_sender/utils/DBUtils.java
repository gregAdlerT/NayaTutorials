package lesson_03_design_patterns.mail_sender.utils;

import java.util.Random;

/**
 * @author Greg Adler
 */
public class DBUtils {
    private static final int AMOUNT_SERVICES = 2;
    private static Random random =new Random();
    public static int getMailCode(){
        return random.nextInt(AMOUNT_SERVICES)+1;
    }
}
