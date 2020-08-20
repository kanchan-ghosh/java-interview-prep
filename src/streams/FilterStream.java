package streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FilterStream {
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(0,25);
        int[] vals = intStream.filter(value -> value > 15).toArray();
        System.out.println(Arrays.toString(vals));
    }
}
