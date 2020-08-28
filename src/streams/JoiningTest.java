package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram", "Lakshman", "Bharat", "Shatrughna");

        String allnames = names.stream().collect(Collectors.joining(", ")).toString();

        System.out.println(allnames);
    }
}
