package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting2 {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(new Car("Maruti Alto", 2000),
                new Car("Porsche", 24000), new Car("Skoda", 12000),
                new Car("Hundai", 3600), new Car("Mahindra", 5000));

        cars.stream().sorted(Comparator.comparing(Car::getPrice)).forEach(System.out::println);
    }
}