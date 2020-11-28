package lesson08aspect.quoters_aspects.quoterss;

import lesson05my_spring.configuration.annotations.InjectRandomInt;
import lesson08aspect.quoters_aspects.bpp.Book;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Greg Adler
 */
@Getter
@Setter
@Book
public class ShakespeareQuoter implements Quoter {
    @InjectRandomInt(min = 3,max = 6)
    private int repeat;
    @Value("${shake}")
    private String message;

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
