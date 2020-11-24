package lesson_04_design_patterns.home_work;

/**
 * @author Greg Adler
 */
public class DivideForSecondDegreeExerciseGenerator implements ExerciseGenerator {
    private GeneratorAssistant assistant=new GeneratorAssistantImpl(1,10);
    @Override
    public Exercise generate() {
        Exercise exercise = assistant.generateTemplate();
        exercise.setOperation(Operation.DIVIDE.getSign());
        exercise.setAnswer(Operation.DIVIDE.getOperator().applyAsDouble(exercise.getOperand1(),exercise.getOperand2()));
        return exercise;
    }
}
