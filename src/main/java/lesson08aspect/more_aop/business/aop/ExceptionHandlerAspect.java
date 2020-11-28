package lesson08aspect.more_aop.business.aop;

import lesson08aspect.more_aop.business.DBException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author Greg Adler
 */
@Aspect
public class ExceptionHandlerAspect {
    
    private Map<DBException,Void> exceptions=new WeakHashMap<>();
    
    @Value("${dba}")
    private String []emails;
    
    @Pointcut("execution(* lesson08aspect.more_aop.business.SomeService.*(..))")
    public void allBusinessMethods(){}
    
    @AfterThrowing(pointcut = "allBusinessMethods()",throwing = "e")
    public void handleException(DBException e){

        if (!exceptions.containsKey(e)) {
            for (String email : emails) {
                System.out.println("Mail sent to "+email+" content:"+e.getMessage());
                exceptions.put(e,null);
            }
        }
    }
}

