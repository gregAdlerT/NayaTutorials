package lesson_01_enum.enums.second_impl;
import lombok.RequiredArgsConstructor;
/**
 * @author Greg Adler
 */
@RequiredArgsConstructor
public enum ReturnCode {
    INFORMATIONAL(100,199,"Мы Фирма серьезная и солидная"),
    SUCCESS(200,299,"Все готово, все сейчас будет..."),
    REDIRECTION(300,399,"Секундочку перевожу вас к специалисту"),
    CLIENT_ERROR(400,499,"Брат, ты не прав! Так дела не делаются"),
    SERVER_ERROR(500,599,"Тут у нас маленькая заминка...");
    private final int min;
    private final int max;
    private final String message;
    
    public static String getMessageByCode(int code){
        ReturnCode[] values = values();
        for (ReturnCode value : values) {
            if (value.min<=code && value.max>code)return value.message;
        }
        throw new IllegalArgumentException("Code: "+code+" not supported");
    }
}
