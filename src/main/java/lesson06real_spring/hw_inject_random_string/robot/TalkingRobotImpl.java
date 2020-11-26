package lesson06real_spring.hw_inject_random_string.robot;

import lesson06real_spring.hw_inject_random_string.quoterss.Quoter;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Greg Adler
 */
@Getter
@Setter
public class TalkingRobotImpl implements TalkingRobot {
    List<Quoter> quotes;
    @Override
    @PostConstruct
    public void talk() {
        quotes.forEach(q->q.sayQuote());
    }
}
