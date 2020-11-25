package lesson05my_spring.services.worker_service;

import lesson05my_spring.configuration.annotations.Benchmark;

/**
 * @author Greg Adler
 */
public class WorkerImpl {

    @Benchmark
 //   @Override
    public void doWork() {
        System.out.println("I Working..............");
    }

    @Benchmark
//    @Override
    public void drinkBeer() {
        System.out.println("TIME TO DRINK!!!");
    }
}
