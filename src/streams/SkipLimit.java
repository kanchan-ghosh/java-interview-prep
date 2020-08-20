package streams;

import java.util.stream.IntStream;

public class SkipLimit {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(0, 15);
        intStream.skip(3).limit(5).forEach(System.out::println);
    }
}
