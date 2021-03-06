package lesson04design_patterns.singleton.implementations;

/**
 * @author Greg Adler
 */
public class LazySingleton {
    private static volatile LazySingleton instance=null;
    
    private LazySingleton(){
    }
    
    public static LazySingleton getInstance(){
        if (instance==null){
            synchronized (instance){
                if (instance==null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
