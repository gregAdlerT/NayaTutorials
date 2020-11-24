package Lesson_04_design_patterns.home_work;

/**
 * @author Greg Adler
 */
public class MinusForSecondDegreeExerciseGenerator implements ExerciseGenerator {
    private GeneratorAssistant assistant=new GeneratorAssistantImpl(0,100);
    @Override
    public Exercise generate() {
        Exercise exercise = assistant.generateTemplate();
        exercise.setOperation(Operation.MINUS.getSign());
        exercise.setAnswer(Operation.MINUS.getOperator().applyAsDouble(exercise.getOperand1(),exercise.getOperand2()));
        return exercise;
    }
}
