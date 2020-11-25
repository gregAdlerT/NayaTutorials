package lesson04design_patterns.home_work;

import lesson04design_patterns.heroes_my_implementation.utils.RandomUtils;
import lombok.AllArgsConstructor;

/**
 * @author Greg Adler
 */
@AllArgsConstructor
public class GeneratorAssistantImpl implements GeneratorAssistant {
    private int min;
    private int max;
    @Override
    public Exercise generateTemplate() {
        return Exercise
                .builder()
                .operand1(RandomUtils.getRandomInRange(min,max))
                .operand2(RandomUtils.getRandomInRange(min,max)).build();
    }
}
