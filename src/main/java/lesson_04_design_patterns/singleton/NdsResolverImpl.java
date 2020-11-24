package lesson_04_design_patterns.singleton;

import lombok.SneakyThrows;

/**
 * @author Greg Adler
 */
public class NdsResolverImpl implements NdsResolver {
    private double nds;
    
    @Override
    public double getNds() {
        if (nds==0){
            nds=getNdsFromCentralBank();
        }
        return nds;
    }

    @SneakyThrows
    private double getNdsFromCentralBank() {
        Thread.sleep(1000);
        return 0.5;
    }
}
