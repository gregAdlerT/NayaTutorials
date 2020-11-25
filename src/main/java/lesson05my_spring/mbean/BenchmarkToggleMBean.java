package lesson05my_spring.mbean;

/**
 * @author Greg Adler
 */
// switch added to ProxyConfiguratorImpl
public interface BenchmarkToggleMBean {
  
    boolean isEnable();
    void setEnable(boolean enable);
}
