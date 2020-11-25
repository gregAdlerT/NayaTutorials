package lesson03optional.stream_api_collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @author Greg Adler
 */
@RequiredArgsConstructor
@Getter
public enum Seniority {
    JUNIOR(0,9999),
    MIDDLE(10_000,19_999),
    SENIOR(20_000,Integer.MAX_VALUE);
    private final int min;
    private final int max;
    
    public static Seniority classificationBySalary(int salary){
//        if (salary>=Seniority.JUNIOR.min && salary<=Seniority.JUNIOR.max)return Seniority.JUNIOR;
//        if (salary>=Seniority.MIDDLE.min && salary<=Seniority.MIDDLE.max)return Seniority.MIDDLE;
//        if (salary>=Seniority.SENIOR.min && salary<=Seniority.SENIOR.max)return Seniority.SENIOR;
//        throw new IllegalArgumentException("Salary must be greater than 0 and less then "+Integer.MAX_VALUE);
      return   Arrays.stream(values())
                .filter(s->s.min<=salary && s.max>=salary)
                .findAny()
                .orElseThrow(()->new IllegalStateException("Salary must be greater than 0 and less then "+Integer.MAX_VALUE));
    }
}
