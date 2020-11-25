package lesson04design_patterns.singleton.implementations;

/**
 * @author Greg Adler
 */
public class PughLazySingleton {
    private PughLazySingleton(){}
    
    private static class InstanceHolder{
        private static PughLazySingleton instance=new PughLazySingleton();
    }
    
    public static PughLazySingleton getInstance(){
        return InstanceHolder.instance;
    }
    
}
