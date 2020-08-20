package streams;

import java.util.stream.IntStream;

public class Reduction {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1,8, 5, 4);
        int max = intStream.max().getAsInt();
        System.out.println("Max value " + max);
    }
}
