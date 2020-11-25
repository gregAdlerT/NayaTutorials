package lesson05my_spring.services.irobot_service;

import lesson05my_spring.configuration.annotations.Benchmark;
import lesson05my_spring.configuration.annotations.InjectRandomInt;
import lesson05my_spring.configuration.annotations.OnInit;
import lesson05my_spring.services.irobot_service.interfaces.Cleaner;

/**
 * @author Greg Adler
 */
@Benchmark
public class SimpleCleaner implements Cleaner {
    @InjectRandomInt(min = 3,max = 10)
    private int repeat;
    
    @OnInit
    public void init(){
        System.out.println(repeat);
    }
    
    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("Cleaning...........");
        }
    }
}
