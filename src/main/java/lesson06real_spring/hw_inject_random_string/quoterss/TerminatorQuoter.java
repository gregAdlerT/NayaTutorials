package lesson06real_spring.hw_inject_random_string.quoterss;

import lesson05my_spring.configuration.annotations.Benchmark;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

/**
 * @author Greg Adler
 */
@Getter
@Setter
@Benchmark
public class TerminatorQuoter implements Quoter {
    private List<String>messages= Arrays.asList("First");
    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
    
 //   @PreDestroy
    public void killAll(){
        System.out.println("You are terminated");
    }
}
