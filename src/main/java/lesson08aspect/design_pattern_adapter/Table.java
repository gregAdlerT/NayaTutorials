package lesson08aspect.design_pattern_adapter;

/**
 * @author Greg Adler
 */
public class Table implements Costable {
    @Override
    public double getCost() {
        return 10.3;
    }
}
