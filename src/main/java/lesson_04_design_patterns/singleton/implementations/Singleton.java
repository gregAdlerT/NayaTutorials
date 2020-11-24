package lesson_04_design_patterns.singleton.implementations;

/**
 * @author Greg Adler
 */
public class Singleton {
    private static Singleton instance =new Singleton();
    
    private Singleton(){}
    
    public static Singleton getInstance(){
        return instance;
    }
}
