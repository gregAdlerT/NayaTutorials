package lesson04design_patterns.home_work;

/**
 * @author Greg Adler
 */
public class MultiplyForSecondDegreeExerciseGenerator implements ExerciseGenerator {
    private GeneratorAssistant assistant=new GeneratorAssistantImpl(1,10);
    @Override
    public Exercise generate() {
        Exercise exercise = assistant.generateTemplate();
        exercise.setOperation(Operation.MULTIPLY.getSign());
        exercise.setAnswer(Operation.MULTIPLY.getOperator().applyAsDouble(exercise.getOperand1(),exercise.getOperand2()));
        return exercise;
    }
}
