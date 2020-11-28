package lesson08aspect.design_pattern_adapter;

/**
 * @author Greg Adler
 */
public class Chair implements Costable {
    @Override
    public double getCost() {
        return 2.3;
    }
}
