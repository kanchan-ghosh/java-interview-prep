package streams;

import java.util.stream.IntStream;

public class Reduction2 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1,2,3,4,5,6,7,8);
        int product = intStream.reduce((a,b) -> a*b).getAsInt();
        System.out.printf("product is %d%n", product);
    }
}
