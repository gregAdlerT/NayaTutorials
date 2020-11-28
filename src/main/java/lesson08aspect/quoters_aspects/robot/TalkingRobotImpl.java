package lesson08aspect.quoters_aspects.robot;

import lesson08aspect.quoters_aspects.bpp.Secured;
import lesson08aspect.quoters_aspects.quoterss.Quoter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Greg Adler
 */
@Getter
@Setter
@Component
public class TalkingRobotImpl implements TalkingRobot {
    @Autowired
    List<Quoter> quotes;
    
    @Override
    @EventListener(ContextRefreshedEvent.class)
    @Secured
    public void talk() {
        quotes.forEach(q->q.sayQuote());
    }
}
