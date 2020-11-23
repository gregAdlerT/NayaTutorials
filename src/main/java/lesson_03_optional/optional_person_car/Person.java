package lesson_03_optional.optional_person_car;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

/**
 * @author Greg Adler
 */
@Data
@AllArgsConstructor
public class Person {
    private String name;
    private Optional<Car> car;
}
