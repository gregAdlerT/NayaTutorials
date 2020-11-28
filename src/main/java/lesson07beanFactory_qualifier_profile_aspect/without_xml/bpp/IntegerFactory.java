package lesson07beanFactory_qualifier_profile_aspect.without_xml.bpp;

import lesson04design_patterns.heroes.RandomUtils;

/**
 * @author Greg Adler
 */
public class IntegerFactory  {

    public Integer createInteger() throws Exception {
        return RandomUtils.getRandomInRange(0, 100);
    }
    
}
