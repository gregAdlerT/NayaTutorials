package lesson04design_patterns.home_work;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Greg Adler
 */
public class ExamenatorTest {

    @Test
    public void getExercises() {
        Examenator examenator = new Examenator();
        List<Exercise> exercises = examenator.getExercises(10);
        Assert.assertEquals(10,exercises.size());
    }
}
