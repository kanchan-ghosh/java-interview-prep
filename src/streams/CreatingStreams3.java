package streams;

import java.util.Comparator;
import java.util.stream.Stream;

public class CreatingStreams3 {
    public static void main(String[] args) {
        Stream<String> colors = Stream.of("red", "green", "blue");
        String col = colors.skip(2).findFirst().get();
        System.out.println(col);

        Stream<Integer> nums = Stream.of(2,3,24,5,6,7);
        Integer maxVal = nums.max(Comparator.naturalOrder()).get();
        System.out.println(maxVal);
    }
}
