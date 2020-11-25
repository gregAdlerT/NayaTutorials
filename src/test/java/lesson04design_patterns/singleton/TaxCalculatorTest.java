package lesson04design_patterns.singleton;


import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Greg Adler
 */
public class TaxCalculatorTest {
    
    @Test
    public void withNds() {
        NdsResolver mock = Mockito.mock(NdsResolver.class);
        Mockito.when(mock.getNds()).thenReturn(0.5);
        
        TaxCalculator taxCalculator = new TaxCalculator(mock);
        double answer=taxCalculator.withNds(100);
        Assert.assertEquals(150,answer,0.000001);
    }

}
