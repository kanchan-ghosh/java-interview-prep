package streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class CreatingStreams2 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1,16);
        System.out.println(intStream.sum());

        DoubleStream doubleStream = DoubleStream.of(2.3, 30.2, 22.9, 45.8);
        doubleStream.forEachOrdered(System.out::println);

        LongStream longStream = LongStream.range(6, 25);
        System.out.println(longStream.count());
    }
}
