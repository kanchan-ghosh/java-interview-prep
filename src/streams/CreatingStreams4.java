package streams;

import java.util.Random;
import java.util.stream.Stream;

public class CreatingStreams4 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(5, n -> n*2).limit(10);
        stream.forEach(System.out::println);

        Stream.generate(new Random()::nextDouble)
                .map(e -> e*10)
                .limit(5)
                .forEach(System.out::println);
    }
}
