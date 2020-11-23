package lesson_03_design_patterns.mail_sender.mail_sender_second_impl;

import lesson_03_design_patterns.mail_sender.service.MailGenerator;
import lesson_03_design_patterns.mail_sender.utils.DBUtils;

import java.util.Map;

/**
 * @author Greg Adler
 */
public class DistributionServiceWithAnnotation {
    
    @InjectServices
    private Map<Integer, MailGenerator>services;

    public void sendMail(){
        int mailCode = DBUtils.getMailCode();
        System.out.println(services.get(mailCode).generateMail());
    }
}
