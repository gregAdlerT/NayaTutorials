package lesson08aspect.design_pattern_adapter;


import lesson04design_patterns.heroes.RandomUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author Greg Adler
 */
public class ProductRepo {
    private List<Costable> cache= Arrays.asList(new Chair(),new Table());
    
    public Costable getProduct(){
       return cache.get(RandomUtils.getRandomInRange(0,1));
    }
}
