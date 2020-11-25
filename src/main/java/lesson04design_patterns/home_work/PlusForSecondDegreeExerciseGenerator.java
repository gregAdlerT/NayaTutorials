package lesson04design_patterns.home_work;

/**
 * @author Greg Adler
 */
public class PlusForSecondDegreeExerciseGenerator implements ExerciseGenerator {
    private GeneratorAssistant assistant=new GeneratorAssistantImpl(0,100);
    @Override
    public Exercise generate() {
        Exercise exercise = assistant.generateTemplate();
        exercise.setOperation(Operation.PLUS.getSign());
        exercise.setAnswer(Operation.PLUS.getOperator().applyAsDouble(exercise.getOperand1(),exercise.getOperand2()));
        return exercise;
    }
}
