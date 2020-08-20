package streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Mapping {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1,11);
        int[] squares = intStream.map(e -> e*e).toArray();
        System.out.println(Arrays.toString(squares));
    }
}
