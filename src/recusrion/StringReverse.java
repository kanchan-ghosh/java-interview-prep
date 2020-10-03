package recusrion;

public class StringReverse {
    public static void main(String[] args) {
        String str = "APPLE";
        System.out.println(reverseString(str));
    }

    public static String reverseString(String input) {

        if (input.length() == 0) {
            return "";
        } else {
            return input.charAt(input.length() - 1) + reverseString(input.substring(0, input.length() - 1));
        }
    }
}