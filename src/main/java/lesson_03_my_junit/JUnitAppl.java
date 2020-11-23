package lesson_03_my_junit;

/**
 * @author Greg Adler
 */
public class JUnitAppl {
    public static void main(String[] args) {
        TestRunner testRunner = new TestRunner();
        testRunner.runAllTestsForClassByName("lesson_03_my_junit.ClassForTest");
//        testRunner.runAllTestsForClass(ClassForTest.class);
//        ClassForTest classForTest = new ClassForTest();
//        testRunner.runAllTests(classForTest);
    }
}
