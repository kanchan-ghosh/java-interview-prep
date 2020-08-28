package streams;

import java.util.stream.IntStream;

public class ReducingTest {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(0, 101);
      //  R collect = intStream.collect(Collectors.reducing(0, e -> e, (a, b) -> a + b))
    }
}
