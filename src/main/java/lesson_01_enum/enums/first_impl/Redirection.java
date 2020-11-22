package lesson_01_enum.enums.first_impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Greg Adler
 */
@Getter
@RequiredArgsConstructor
public enum Redirection {
    LOW_LEVEL("Вали от сюда, нищеброд...по данной ссылке"),
    HIGH_LEVEL("Переводим вас к специалисту");
    private final String message;
}
