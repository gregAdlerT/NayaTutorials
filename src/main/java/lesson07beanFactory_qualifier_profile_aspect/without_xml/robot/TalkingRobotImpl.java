package lesson07beanFactory_qualifier_profile_aspect.without_xml.robot;

import lesson07beanFactory_qualifier_profile_aspect.without_xml.bpp.Book;
import lesson07beanFactory_qualifier_profile_aspect.without_xml.quoterss.Quoter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Greg Adler
 */
@Getter
@Setter
@Component
public class TalkingRobotImpl implements TalkingRobot {
    @Autowired
    @Book
    List<Quoter> quotes;
    @Override
    @PostConstruct
    public void talk() {
        quotes.forEach(q->q.sayQuote());
    }
}
