package Lesson_04_design_patterns.singleton;

/**
 * @author Greg Adler
 */
public class TaxCalculator {
    private NdsResolver ndsResolver;

    public TaxCalculator(NdsResolver ndsResolver) {
        this.ndsResolver = ndsResolver;
    }

    public double withNds(double price){
        double nds = ndsResolver.getNds();
        return price*nds+price;
    }

//    public double withNds(double price){
//        
//        return NdsResolverSingleton.getInstance().getNds()* price+price;
//    }
}
