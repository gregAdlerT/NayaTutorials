package lesson07beanFactory_qualifier_profile_aspect.xml_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Greg Adler
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextQuoter.xml");
//        TerminatorQuoter terminatorQuoter = context.getBean(TerminatorQuoter.class);
//        ShakespeareQuoter shakespeareQuoter = context.getBean(ShakespeareQuoter.class);
//        terminatorQuoter.sayQuote();
//        shakespeareQuoter.sayQuote();
//        Map<String, Quoter> quoterImpls = context.getBeansOfType(Quoter.class);
//        quoterImpls.values().forEach(q->q.sayQuote());
        
//        TalkingRobot bean = context.getBean(TalkingRobot.class);
        context.close();
        
    }
}
