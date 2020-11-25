package lesson03optional;

import lesson02lambda.employees.Insurance;
import lesson03optional.optional_person_car.Car;
import lesson03optional.optional_person_car.Person;
import lesson03optional.stream_api_collectors.Employee;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Greg Adler
 */
public class PersonAndFridayCounterAppl {
    public static Random random=new Random();
    public static void main(String[] args) {
        List<Optional<Person>>personList=createPersonList(10);
//        System.out.println(getPersonsByInsurance(personList,Insurance.IDI));
        
        List<Employee>employees=createEmployees(30);
//        System.out.println(employees.stream()
//                .collect(Collectors.groupingBy(e->Seniority.classificationBySalary(e.getSalary()))));

//        System.out.println(employees.stream()
//                .collect(Collectors.groupingBy(e->Seniority.classificationBySalary(e.getSalary()),Collectors.toSet())));
        
//        System.out.println(employees.stream()
//                .collect(Collectors.toMap(Employee::getName,Employee::getSalary,(salary1, salary2) ->salary1+salary2 )));

        fridayCounter(1900,1950);
    }

    private static void fridayCounter(int from, int to) {
        LocalDate dateFrom = LocalDate.of(from, 1, 13);
        LocalDate dateTo = LocalDate.of(to, 12, 31);
        Stream.iterate(dateFrom, d -> d.plusMonths(1))
                .limit(ChronoUnit.MONTHS.between(dateFrom, dateTo))
                .filter(d -> d.getDayOfMonth() == 13 && d.getDayOfWeek() == DayOfWeek.FRIDAY)
                .collect(Collectors.groupingBy(d -> d.getYear(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> (int) (e2.getValue()-e1.getValue()))
                .forEach(System.out::println);
    }

    private static List<Employee> createEmployees(int i) {
        return IntStream.range(1,i+1).mapToObj(num->createEmployee(num)).collect(Collectors.toList());
    }
    
    private static Employee createEmployee(int i) {
        return new Employee("Bob"+i,random.nextInt(50_000));
    }

    private static List<String> getPersonsByInsurance(List<Optional<Person>> personList, Insurance insurance) {
        //first impl
//        List<String>res=new ArrayList<>();
//        personList.forEach(p-> p.ifPresent((per)->per.getCar()
//                .ifPresent(c->c.getInsurance()
//                        .ifPresent(i->{if(i==insurance)res.add(per.getName());}))));
//        return res;
        //second impl
       return personList.stream()
                .filter(p->getCarInsurance(p)==insurance)
                .map(p->p.get().getName())
                .collect(Collectors.toList());
    }

    private static Insurance getCarInsurance(Optional<Person> p) {
        return p.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .orElse(null);
    }

    private static List<Optional<Person>> createPersonList(int i) {
        //used stream
       return IntStream.range(1,i+1).mapToObj(num->createPerson(num)).collect(Collectors.toList());
        
        //used for loop
//        List<String> cars = Arrays.asList("Mazda", "Volvo", "BMW");
//        List<Optional<Person>> res=new ArrayList<>(i);
//        for (int j = 0; j < i; j++) {
//            int ind = random.nextInt(3);
//            Person p=new Person("Jonny"+j,
//                    Optional.of(new Car(cars.get(ind),
//                            ind==1? Optional.of(Insurance.IDI):
//                                    ind==2?Optional.of(Insurance.HAREL):
//                                            Optional.ofNullable(null))));
//            res.add(Optional.ofNullable(p));
//        }
//        return res;
    }

    private static Optional<Person> createPerson(int j) {
        int ind = random.nextInt(3);
        List<String> cars = Arrays.asList("Mazda", "Volvo", "BMW");
        Person p=new Person("Jonny"+j,
                Optional.of(new Car(cars.get(ind),
                        ind==1? Optional.of(Insurance.IDI):
                                ind==2?Optional.of(Insurance.HAREL):
                                        Optional.ofNullable(null))));
        return Optional.of(p);
    }
}
