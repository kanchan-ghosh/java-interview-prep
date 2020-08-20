package streams;

import java.util.stream.Stream;

public class Mapping2 {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("apple", "leMon", "banaNa", "juIce");
        stringStream.map(Mapping2::capitalize).forEach(System.out::println);
    }

    private static String capitalize(String word) {
        word = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
        return word;
    }
}
