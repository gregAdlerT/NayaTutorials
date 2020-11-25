package lesson05my_spring.services.irobot_service;

import lesson05my_spring.configuration.annotations.Benchmark;
import lesson05my_spring.services.irobot_service.interfaces.Speaker;

/**
 * @author Greg Adler
 */
@Benchmark
public class ConsoleSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}
