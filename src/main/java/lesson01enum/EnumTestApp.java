package lesson01enum;

import lesson01enum.enums.first_impl.HttpCode;
import lesson01enum.enums.second_impl.ReturnCode;

/**
 * @author Greg Adler
 */
public class EnumTestApp {
    public static void main(String[] args) {
        // first implementation with one enum class
        System.out.println("First impl result: "+ReturnCode.getMessageByCode(200));
        // second implementation with multiply inner enums
        System.out.println("Second impl result: "+HttpCode.getMessageByCode(549));
        
    }
}
