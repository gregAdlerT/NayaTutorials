package lesson01enum.enums.first_impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Greg Adler
 */
@Getter
@RequiredArgsConstructor
public enum ClientError {
    LOW_LEVEL("Ошибочка!! проверь себя еще раз"),
    HIGH_LEVEL("Наши глубочайшие извенения, но у вас тут небольшая ошибка ввода");
    private final String message;
}
