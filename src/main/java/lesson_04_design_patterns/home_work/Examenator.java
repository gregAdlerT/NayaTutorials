package lesson_04_design_patterns.home_work;

import lesson_04_design_patterns.heroes_my_implementation.utils.RandomUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Greg Adler
 */
public class Examenator {
    private List<ExerciseGenerator>generators= Arrays.asList(
            new PlusForSecondDegreeExerciseGenerator(),
            new MinusForSecondDegreeExerciseGenerator(),
            new MultiplyForSecondDegreeExerciseGenerator(),
            new DivideForSecondDegreeExerciseGenerator()
    );
    public List<Exercise> getExercises(int amount){
        return IntStream.range(0,amount)
                .mapToObj(__->{
                    ExerciseGenerator exerciseGenerator = generators.get(RandomUtils.getRandomInRange(0, generators.size() - 1));
                    return exerciseGenerator.generate();}).collect(Collectors.toList());
    }
}
