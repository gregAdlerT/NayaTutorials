package lesson08aspect.design_pattern_adapter;

import java.util.List;

/**
 * @author Greg Adler
 */
public class PriceCalculator {
    public double calculate(List<Priceable>products){
        return products.stream().mapToDouble(Priceable::getPrice).sum();
    }
}
