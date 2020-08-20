package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Collecting2 {
    public static void main(String[] args) {

        List<String> items = Arrays.asList("red", "green", "orange","red", "blue", "red", "orange", "orange", "green",
                "red", "blue", "orange", "green", "green", "green", "green", "blue", "orange", "red" );

        Map<String, List<String>> collect = items.stream().collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.toList()
                )
        );

        for(Map.Entry<String, List<String>> entry : collect.entrySet()) {
            System.out.printf("%s : %d %n", entry.getKey(), entry.getValue().size());
        }

    }
}
