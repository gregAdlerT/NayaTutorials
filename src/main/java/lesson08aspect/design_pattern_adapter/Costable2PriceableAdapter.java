package lesson08aspect.design_pattern_adapter;

import lombok.AllArgsConstructor;

/**
 * @author Greg Adler
 */
@AllArgsConstructor
public class Costable2PriceableAdapter implements Priceable{

    private Costable costable;
    @Override
    public double getPrice() {
        return costable.getCost();
    }
}
