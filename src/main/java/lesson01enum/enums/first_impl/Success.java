package lesson01enum.enums.first_impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Greg Adler
 */
@Getter
@RequiredArgsConstructor
public enum Success {
    LOW_LEVEL("На лови, это все что нашли"),
    HIGH_LEVEL("результаты по вашему запросу");
    private final String message;
}
