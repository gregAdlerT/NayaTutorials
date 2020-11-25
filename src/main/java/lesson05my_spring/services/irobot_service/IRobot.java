package lesson05my_spring.services.irobot_service;


import lesson05my_spring.configuration.annotations.InjectByType;
import lesson05my_spring.services.irobot_service.interfaces.Cleaner;
import lesson05my_spring.services.irobot_service.interfaces.Speaker;

/**
 * @author Greg Adler
 */
public class IRobot {
    @InjectByType
    private Speaker speaker ;
    @InjectByType
    private Cleaner cleaner;


    public void cleanRoom(){
        speaker.speak("I started......");
        cleaner.clean();
        speaker.speak("I started......");

    }
}
