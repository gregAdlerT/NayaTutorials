package lesson06real_spring.hw_inject_random_string.quoterss;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author Greg Adler
 */
//  @EnableAspectJAutoProxy use this annotation in configuration class
@Aspect
public class QuoterAspect {
    @Before(" @annotation(Deprecated)")
    public void a(){
        System.out.println("Dont use!");
    }
    @After(" @annotation(Deprecated)")
    public void b(){
        System.out.println("I talk to you, Dont use!");
    }   
    @SneakyThrows
    @Around(" @annotation(Deprecated)")
    public void a(ProceedingJoinPoint pjp){
        System.out.println("Dont use!");
        pjp.proceed();
        System.out.println("I talk to you, Dont use!");
    }
}
