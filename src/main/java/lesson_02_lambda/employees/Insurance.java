package lesson_02_lambda.employees;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Greg Adler
 */
@RequiredArgsConstructor
@Getter
public enum Insurance {
    HAREL("Harel"),IDI("IDI");
    private final String name;
}
