package lesson_03_design_patterns.mail_sender.mail_sender_first_impl;

import lesson_03_design_patterns.mail_sender.service.EmailCallbackMailGen;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lesson_03_design_patterns.mail_sender.service.MailGenerator;
import lesson_03_design_patterns.mail_sender.service.WelcomeMailGen;

import java.util.Arrays;

/**
 * @author Greg Adler
 */
@RequiredArgsConstructor
@Getter
public enum Mail {
    WELCOME(1,new WelcomeMailGen()),
    EMAIL_CALLBACK(2,new EmailCallbackMailGen());
    private final int code;
    private final MailGenerator mailGenerator;
    
    public static MailGenerator getServiceByCode(int code){
        Mail mail = Arrays.stream(values()).filter(v -> v.code == code).findAny()
                .orElseThrow(() -> new UnsupportedOperationException("Code: " + code + " not supported yet"));
        return mail.mailGenerator;
    }
}
