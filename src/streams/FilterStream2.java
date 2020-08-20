package streams;

import java.util.stream.IntStream;

public class FilterStream2 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(0, 30);
        intStream.filter(FilterStream2::isEven).forEach(System.out::println);
    }

    private static boolean isEven(int e) {
        return e % 2 == 0;
    }
}
