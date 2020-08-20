package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreatingStreams {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("pen", "coin", "desk", "chair");

        String word = words.stream().findFirst().get();
        System.out.println(word);

        Stream<String> letters = Arrays.stream(new String[]{"a", "b", "c"});
        System.out.printf("There are %d letters \n", letters.count());

        String day = "Sunday";
        IntStream istr = day.codePoints();

        String s = istr.filter(e -> e!='n').collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        System.out.println(s);
    }
}
