package streams;

import java.util.Arrays;
import java.util.List;

public class InternalIteration {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("pen", "coin", "desk", "table", "bottle");
        words.stream().forEach(System.out::println);
    }
}
