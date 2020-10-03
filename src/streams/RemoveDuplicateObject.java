package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveDuplicateObject {
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

        // 1. remove consecutive duplicates only
        System.out.println("================= Removing only consecutive duplicates ==================");
        IntStream.range(0, carList.size())
                .filter(
                        i -> (
                                ( i < carList.size() - 1 && !carList.get(i).equals(carList.get(i+1) ) ) ||
                                        i == carList.size() - 1
                        )
                ).mapToObj(carList::get).collect(Collectors.toList()).forEach(System.out::println);


        System.out.println("================= Removing all duplicates ==================");
        carList.stream().distinct().forEach(System.out::println);
    }

}
