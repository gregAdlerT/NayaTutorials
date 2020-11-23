package lesson_03_design_patterns.mail_sender.mail_sender_third_impl;


import lesson_03_design_patterns.mail_sender.utils.DBUtils;
import lesson_03_design_patterns.mail_sender.service.MailGenerator;

import java.util.Map;

/**
 * @author Greg Adler
 */
public class DistributionServiceWithAnnotationInjectableClass {
    
    private Map<Integer, MailGenerator>services;

    public void sendMail(){
        int mailCode = DBUtils.getMailCode();
        InjectableClassProcessor injectableClassProcessor = new InjectableClassProcessor();
        services=injectableClassProcessor.process(MailGenerator.class);
        if (!services.containsKey(mailCode)){
            throw new UnsupportedOperationException("Mail code:"+mailCode+" not supported yet");
        }
        System.out.println(services.get(mailCode).generateMail());
    }
}
