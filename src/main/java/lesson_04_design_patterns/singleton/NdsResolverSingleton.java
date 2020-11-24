package lesson_04_design_patterns.singleton;

/**
 * @author Greg Adler
 */
public class NdsResolverSingleton implements NdsResolver{
    private static NdsResolverSingleton instance=new NdsResolverSingleton();
   
    private NdsResolverSingleton(){}
    
    public static NdsResolverSingleton getInstance(){
        return instance;
    }
    @Override
    public double getNds(){
        return 0.5;
    }
}
