package lesson_03_design_patterns.mail_sender;

import lesson_03_design_patterns.mail_sender.mail_sender_first_impl.DistributionServiceWithEnum;
import lesson_03_design_patterns.mail_sender.mail_sender_second_impl.DistributionServiceWithAnnotation;
import lesson_03_design_patterns.mail_sender.mail_sender_second_impl.InjectServiceProcessor;
import lesson_03_design_patterns.mail_sender.mail_sender_third_impl.DistributionServiceWithAnnotationInjectableClass;
import lesson_03_design_patterns.mail_sender.service.MailGenerator;

/**
 * @author Greg Adler
 */
public class MailServiceAppl {
    public static void main(String[] args) {
        //implementation with enum
        InjectServiceProcessor injectServiceProcessor = new InjectServiceProcessor();
        DistributionServiceWithEnum distributionService = new DistributionServiceWithEnum();
        distributionService.sendMail();

        //implementation with annotation @InjectServices
        DistributionServiceWithAnnotation annotatedDistributionService =
                (DistributionServiceWithAnnotation) injectServiceProcessor.process(MailGenerator.class);
        annotatedDistributionService.sendMail();

        //implementation with annotation @InjectableClass
        DistributionServiceWithAnnotationInjectableClass distributionServiceWithAnnotationInjectableClass = 
                new DistributionServiceWithAnnotationInjectableClass();
        distributionServiceWithAnnotationInjectableClass.sendMail();
    }
}
