package lesson06real_spring.hw_inject_random_string.soldiers;

import lombok.Data;

/**
 * @author Greg Adler
 */
@Data
public class Летчик extends Soldier {
    @Override
    public void fight() {
        System.out.println("Лови бомбу");
    }
}
