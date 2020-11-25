package lesson01enum.enums.first_impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Greg Adler
 */
@Getter
@RequiredArgsConstructor
public enum  ServerError {
    LOW_LEVEL("Наш косяк, сейчас исправляем"),
    HIGH_LEVEL("Приносим свои извинения, но есть неполадки с сервером. Мы уже работаем над его восстановлением");
    private final String message;
}
