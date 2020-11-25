package lesson01enum.enums.first_impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Greg Adler
 */
@Getter
@RequiredArgsConstructor
public enum Informational {
    LOW_LEVEL("Полетели со мной, там столько вкусного..."),
    HIGH_LEVEL("Вот что я тебе скажу, птичка...");
    private final String message;
}
