package lesson_03_optional.stream_api_collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Greg Adler
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private String name;
    private int salary;
}
