package lesson_02_lambda;

import lesson_02_lambda.animals.AnimalFactory;
import lesson_02_lambda.employees.Company;
import lesson_02_lambda.employees.Employee;
import lesson_02_lambda.employees.Insurance;
import lombok.SneakyThrows;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author Greg Adler
 */
public class LambdaAppl {
    public static void main(String[] args) {
        forEachWithDelay(Arrays.asList("AAA","BBB"),100,(s)-> System.out.println(s));
        AnimalFactory animalFactory = new AnimalFactory();
        animalFactory.createRandomAnimal().doVoice();
        animalFactory.createRandomAnimal();
        
        List<Employee>employees=createEmployees(10);
        employees.stream().
                filter(e->e.getInsurance()== Insurance.IDI).
                map(Employee::getCompany).
                sorted(Comparator.comparingInt(Company::getRevenue)).
                map(Company::getCompanyName).
                distinct().
                forEach(System.out::println);
        
        // this implementation 1 stream operation less than first
        employees.stream().
                filter(e->e.getInsurance()== Insurance.IDI).
                map(Employee::getCompany).
                sorted(Comparator.comparingInt(Company::getRevenue)).
                distinct().
                forEach(c-> System.out.println(c.getCompanyName()));

    }

    private static List<Employee> createEmployees(int i) {
        List<Company>companies=createCompanies(i/2);
        return companies.stream().map(company -> {
            int suf = company.getRevenue()/1_000_000;
            return Arrays.asList(new Employee("Employee_"+suf,company,suf%2==0? Insurance.HAREL: Insurance.IDI),
            new Employee("Employee_"+suf*2,company,suf%2==0? Insurance.HAREL: Insurance.IDI));
        }).flatMap(Collection::stream).collect(Collectors.toList());
    }

    private static List<Company> createCompanies(int i) {
        List<Company>res=new ArrayList<>();
        for (int j = 0; j < i; j++) {
            res.add(new Company("Company"+j,j*1_000_000));
        }
        return res;
    }


    @SneakyThrows
    public static <T> void forEachWithDelay(List<T> list, int delay, Consumer function) {
        for (T t : list) {
            function.accept(t);
            Thread.sleep(delay);
        }
    }
}
