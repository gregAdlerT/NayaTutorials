package lesson_02_lambda.employees;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Greg Adler
 */
@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private Company company;
    private Insurance insurance;
}
