package lesson_02_lambda.employees;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Greg Adler
 */
@Data
@AllArgsConstructor
public class Company {
    private String companyName;
    private int revenue;
}
