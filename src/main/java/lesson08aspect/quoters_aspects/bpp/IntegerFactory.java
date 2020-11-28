package lesson08aspect.quoters_aspects.bpp;

import lesson04design_patterns.heroes.RandomUtils;

/**
 * @author Greg Adler
 */
public class IntegerFactory  {

    public Integer createInteger() throws Exception {
        return RandomUtils.getRandomInRange(0, 100);
    }
    
}
