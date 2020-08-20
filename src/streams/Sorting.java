package streams;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Sorting {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(4,3,2,11,8,6,9,1,5);
        intStream.boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
