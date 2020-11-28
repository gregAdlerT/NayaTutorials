package lesson07beanFactory_qualifier_profile_aspect.xml_introduction.bpp;

import lesson04design_patterns.heroes.RandomUtils;

/**
 * @author Greg Adler
 */
public class IntegerFactory  {

    public Integer createInteger() throws Exception {
        return RandomUtils.getRandomInRange(0, 100);
    }
    
}
