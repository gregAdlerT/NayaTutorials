package lesson_03_optional.optional_person_car;

import lesson_02_lambda.employees.Insurance;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

/**
 * @author Greg Adler
 */
@Data
@AllArgsConstructor
public class Car {
    private String model;
    private Optional<Insurance> insurance;
}
