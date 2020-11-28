package lesson08aspect.quoters_aspects.aop;

import lesson04design_patterns.heroes.RandomUtils;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Greg Adler
 */
//  @EnableAspectJAutoProxy use this annotation in configuration class
@Aspect
@Component
public class QuoterAspect {
    
    @Pointcut("execution(* lesson08aspect.quoters_aspects.quoterss.*.say*(..))")
    public static void allSayMethods(){}
    
    @Before("allSayMethods()")
    public void handleSayMethod(JoinPoint point){
        String name = point.getTarget().getClass().getSimpleName();
        System.out.println("А теперь цитата "+name+" :");
    }
    
    @SneakyThrows
    @Around("@annotation(lesson08aspect.quoters_aspects.bpp.Secured)")
    public Object doSecure(ProceedingJoinPoint pjp){
        if (RandomUtils.getRandomInRange(0,10)<5){
            return pjp.proceed();
        }else {
            throw new SecurityException("not allowed here, try later");
        }
    }
    
    
    
//    @Before(" @annotation(Deprecated)")
//    public void a(){
//        System.out.println("Dont use!");
//    }
//    @After(" @annotation(Deprecated)")
//    public void b(){
//        System.out.println("I talk to you, Dont use!");
//    }   
    @SneakyThrows
    @Around(" @annotation(Deprecated)")
    public void a(ProceedingJoinPoint pjp){
        System.out.println("Dont use!");
        pjp.proceed();
        System.out.println("I talk to you, Dont use!");
    }
}
