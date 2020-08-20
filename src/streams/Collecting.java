package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collecting {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("Suzuki", 2000),
                new Car("Porsche", 24000),
                new Car("Skoda", 12000),
                new Car("Hundai", 3600),
                new Car("Mahindra", 5000)
        );

        cars.stream().map(Car::getName).filter(name -> name.startsWith("S"))
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}
