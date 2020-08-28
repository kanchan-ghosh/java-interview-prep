package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PeekTest {
    public static void main(String[] args) {
        Car[] carsArr = {
                new Car("Maruti Alto", 2000),
                new Car("Porsche", 24000), new Car("Skoda", 12000),
                new Car("Hundai", 3600), new Car("Mahindra", 5000)
        };

        List<Car> cars = Arrays.asList(carsArr);

        cars.stream()
                .peek(e -> e.increasePrice(10))
                .peek(System.out::println)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
