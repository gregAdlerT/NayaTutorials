package lesson08aspect.quoters_aspects.quoterss;

import lesson05my_spring.configuration.annotations.Benchmark;
import lesson08aspect.quoters_aspects.bpp.Film;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;

/**
 * @author Greg Adler
 */
@Data
@Benchmark
//@DeprecatedClass(newClass = T1000.class)
@Film
public class TerminatorQuoter implements Quoter {
    
    private List<String>messages;

    @Value("${terminator}")
    public void setMessages(String[] messages,@Value("${JAVA_HOME}") String javaHome) {
        this.messages = Arrays.asList(messages);
        System.out.println("java home: "+javaHome);
    }

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
    
 //   @PreDestroy
    public void killAll(){
        System.out.println("You are terminated");
    }
}
