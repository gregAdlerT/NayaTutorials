package lesson04design_patterns.home_work;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Greg Adler
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
    private double operand1;
    private String operation;
    private double operand2;
    private double answer;

    @Override
    public String toString() {
        return operand1+""+operation+operand2+"="+answer;
    }
}
