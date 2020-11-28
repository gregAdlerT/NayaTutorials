package lesson07beanFactory_qualifier_profile_aspect.xml_introduction.quoterss;

import lesson05my_spring.configuration.annotations.Benchmark;
import lesson07beanFactory_qualifier_profile_aspect.xml_introduction.bpp.DeprecatedClass;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author Greg Adler
 */
@Data
@Benchmark
@DeprecatedClass(newClass = T1000.class)
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
