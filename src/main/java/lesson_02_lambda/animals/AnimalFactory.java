package lesson_02_lambda.animals;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author Greg Adler
 */
public class AnimalFactory {
    private List<Supplier<Animal>>animals= Arrays.asList(Cat::new,Dog::new);
    Random random=new Random();
    public Animal createRandomAnimal(){
        int i = random.nextInt(animals.size());
        return animals.get(i).get();
    }
}
