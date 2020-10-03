package streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class PrintIndexAndObject {
    public static void main(String[] args) {
        List<Car> carList = Arrays.asList(
                new Car("Suzuki", 2000),
                new Car("Suzuki", 2100),
                new Car("Porsche", 24000),
                new Car("Skoda", 12000),
                new Car("Skoda", 12000),
                new Car("Hundai", 3600),
                new Car("Mahindra", 5000),
                new Car("Porsche", 24000),
                new Car("Skoda", 12000)
        );

        // 1. Generate the index with IntStream.range.
        IntStream.range(0, carList.size())
                .mapToObj(i -> "Index : " + i + " = Object : " + carList.get(i).toString())
                .forEach(System.out::println);

        System.out.println("==========================================================");

        // 2. Convert the List into a Map, and uses the Map.size as the index.
        carList.stream()
                .collect(HashMap<Integer, Car>::new, (map, car) -> map.put(map.size(), car), (map, car) -> {} )
                .forEach((index, car) -> System.out.println("Index : " + index + " = Object : " + car));
    }
}
