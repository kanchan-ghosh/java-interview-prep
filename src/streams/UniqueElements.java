package streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class UniqueElements {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1,1,2,3,4,5,3,6,3,1,5,6,9);
        int[] arr = intStream.distinct().toArray();
        System.out.println(Arrays.toString(arr));
    }
}
