package lesson05my_spring;

import lesson05my_spring.services.worker_service.WorkerImpl;
import lesson05my_spring.utils.ObjectFactory;
import lombok.SneakyThrows;

/**
 * @author Greg Adler
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
//        IRobot robot = ObjectFactory.getInstance().createObject(IRobot.class);
//        robot.cleanRoom();
        WorkerImpl worker = ObjectFactory.getInstance().createObject(WorkerImpl.class);
        while (true) {
            worker.doWork();
            worker.drinkBeer();
            Thread.sleep(1000);
        }
    }
}
