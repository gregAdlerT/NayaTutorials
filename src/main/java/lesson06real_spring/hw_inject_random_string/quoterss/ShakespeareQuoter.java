package lesson06real_spring.hw_inject_random_string.quoterss;

import lesson05my_spring.configuration.annotations.InjectRandomInt;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Greg Adler
 */
@Getter
@Setter
public class ShakespeareQuoter implements Quoter {
    @InjectRandomInt(min = 3,max = 6)
    private int repeat;
    private String message;

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
