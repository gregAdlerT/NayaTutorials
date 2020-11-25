package lesson01enum.enums.first_impl;


/**
 * @author Greg Adler
 */
// One more way to implement(not used).
// To add field with this interface, into enum    
@FunctionalInterface
public interface CodeHandler {
    String handle(int code, HttpCode httpCode);

}
