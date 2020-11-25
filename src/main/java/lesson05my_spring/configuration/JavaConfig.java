package lesson05my_spring.configuration;

import lesson05my_spring.configuration.interfaces.Config;
import lesson05my_spring.services.irobot_service.ConsoleSpeaker;
import lesson05my_spring.services.irobot_service.SimpleCleaner;
import lesson05my_spring.services.irobot_service.interfaces.Cleaner;
import lesson05my_spring.services.irobot_service.interfaces.Speaker;
import lesson05my_spring.services.worker_service.Worker;
import lesson05my_spring.services.worker_service.WorkerImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Greg Adler
 */
public class JavaConfig implements Config {
    private Map<Class,Class> ifc2ImplClasses=new HashMap<>();

    public JavaConfig() {
        this.ifc2ImplClasses.put(Cleaner.class, SimpleCleaner.class);
        this.ifc2ImplClasses.put(Speaker.class, ConsoleSpeaker.class);
        this.ifc2ImplClasses.put(Worker.class, WorkerImpl.class);
    }

    @Override
    public <T> Class<T> getInterfaceImpl(Class<T> type) {
        return ifc2ImplClasses.get(type);
    }
}
