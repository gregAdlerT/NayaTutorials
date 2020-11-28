package lesson07beanFactory_qualifier_profile_aspect.home_work.errors_mail_sender_aspects.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Greg Adler
 */
@Aspect
@Component
public class DBExceptionAspect {
    
    private List<String>emails;
    
    @Autowired
    private MailSender mailSender;
    
    @Pointcut("execution(* lesson07beanFactory_qualifier_profile_aspect.home_work.errors_mail_sender_aspects.service.*.get(..))")
    public static void allGetMethods(){}

    @Value("${emails}")
    public void setEmails(String[] emails){
        this.emails= Arrays.asList(emails);
    }
    
    @AfterThrowing(pointcut = "allGetMethods()",
            throwing = "ex")
    public void send(SQLException ex){
        for (String email : emails) {
            mailSender.send(email,ex.getMessage());
        };
    }
    
    @Before(" @annotation(MyDeprecated)")
    public void detectDeprecatedUsage(){
        System.out.println("Are you stupid? Dont use deprecated classes!");
    }
    
}
