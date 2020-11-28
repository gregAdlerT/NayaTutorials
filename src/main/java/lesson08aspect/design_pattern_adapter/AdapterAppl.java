package lesson08aspect.design_pattern_adapter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Greg Adler
 */
public class AdapterAppl {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        List<Priceable> products = Stream.generate(productRepo::getProduct)
                .limit(20)
                .map(Costable2PriceableAdapter::new)
                .collect(Collectors.toList());
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.calculate(products);
    }
}
