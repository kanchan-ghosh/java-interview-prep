package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Apple", "Orange", "Banana"),
                Arrays.asList("Bed", "Chair", "Table"),
                Arrays.asList("Laptop", "Mobile", "iPod")
        );

        List<String> flatList = nestedList.stream().flatMap(Collection::stream).collect(Collectors.toList());

        flatList.stream().forEach(System.out::println);
    }
}
