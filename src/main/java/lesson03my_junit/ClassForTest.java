package lesson03my_junit;

/**
 * @author Greg Adler
 */
public class ClassForTest {

    public void testA(){
        System.out.println("AAA");
    }
    @MyTest
    public void printB(){
        System.out.println("BBB");
    }
    
}
