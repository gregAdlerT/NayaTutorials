package lesson_03_design_patterns.mail_sender.mail_sender_first_impl;


import lesson_03_design_patterns.mail_sender.utils.DBUtils;

/**
 * @author Greg Adler
 */
public class DistributionServiceWithEnum {

    public void sendMail(){
        int mailCode = DBUtils.getMailCode();
        System.out.println(Mail.getServiceByCode(mailCode).generateMail());
    }
}
