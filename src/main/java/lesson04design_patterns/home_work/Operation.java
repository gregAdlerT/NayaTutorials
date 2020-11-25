package lesson04design_patterns.home_work;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.DoubleBinaryOperator;

/**
 * @author Greg Adler
 */
@RequiredArgsConstructor
@Getter
public enum Operation {
    PLUS("+",Double::sum),
    MINUS("-",(o1,o2)->o1-o2),
    MULTIPLY("*",(o1,o2)->o1*o2), 
    DIVIDE("/",(o1,o2)->o1/o2);
    
    private final String sign;
    private final DoubleBinaryOperator operator;

    @Override
    public String toString() {
        return sign;
    }
}
