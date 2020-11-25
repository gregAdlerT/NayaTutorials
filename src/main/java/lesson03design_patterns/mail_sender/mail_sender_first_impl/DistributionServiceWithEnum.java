package lesson03design_patterns.mail_sender.mail_sender_first_impl;


import lesson03design_patterns.mail_sender.utils.DBUtils;

/**
 * @author Greg Adler
 */
public class DistributionServiceWithEnum {

    public void sendMail(){
        int mailCode = DBUtils.getMailCode();
        System.out.println(Mail.getServiceByCode(mailCode).generateMail());
    }
}
