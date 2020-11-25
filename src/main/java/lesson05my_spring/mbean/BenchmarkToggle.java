package lesson05my_spring.mbean;

import lombok.Data;
import lombok.SneakyThrows;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author Greg Adler
 */
@Data
public class BenchmarkToggle implements BenchmarkToggleMBean {
    private boolean enable=true;
    
    @SneakyThrows
    public BenchmarkToggle(){
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(this,new ObjectName("myMBeans","name","Benchmark"));
    }
}
