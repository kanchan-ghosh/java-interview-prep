/**
 *
 * John has an important task - He nneds to number the books in the bookshelf, putting
 * a tag with a number on each book. Each of the N number of books should have a number
 * from 1 to N, and ofcource different books should get different numbers.
 *
 * John wants to know how many digits he has to write down while numbering all those tags
 *
 * Input: The first line contains an integer n - the number of books in the class bookshelf.
 *
 * Output: Output the number of digits needed to number all the books.
 *
 * Constraints: 1 <= n <= 10^9
 *
 * Example:
 *
 * 1.	Input: 4
 * 	    Output : 4
 *
 * 2. 	Input : 13
 * 	    Output: 17  (1 to 9 is 9 digit, then 10 to 13 has 2 digit each so 4*2 = 8 digit, Total 9+8 = 17)
 *
 */

package interview;

public class CountNumberOfDigitsForAValueFromOne {
    public static void main(String[] args) {
        int number1 = 4;
        int number2 = 13;

        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("For input "+ number1 +" Total Number of Digit using iterative solution 1  = "
                + countTotalDigitIterative(number1) );
        System.out.println("For input "+ number2 +" Total Number of Digit using iterative solution 1  = "
                + countTotalDigitIterative(number2) );

        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("For input "+ number1 +" Total Number of Digit using recursive solution 2  = "
                + countTotalDigitRecursive(number1) );
        System.out.println("For input "+ number2 +" Total Number of Digit using recursive solution 2  = "
                + countTotalDigitRecursive(number2) );

        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("For input "+ number1 +" Total Number of Digit using logarithmic solution 3  = "
                + countTotalDigitLogarithmic(number1) );
        System.out.println("For input "+ number2 +" Total Number of Digit using logarithmic solution 3  = "
                + countTotalDigitLogarithmic(number2) );

        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("For input "+ number1 +" Total Number of Digit using String conversion solution 4  = "
                + countTotalDigitAsString(number1) );
        System.out.println("For input "+ number2 +" Total Number of Digit using String conversion solution 4  = "
                + countTotalDigitAsString(number2) );

        System.out.println("-------------------------------------------------------------------------------------");
    }

    //==============================================================================================
    // Solution 1 :  Simple Iterative Solution
    //==============================================================================================
    static int countTotalDigitIterative(long n)
    {
        int total = 0;
        for(int i=1; i<=n; i++) {
            total += countDigitIterative(i);
        }
        return total;
    }

    static int countDigitIterative(long n)
    {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            ++count;
        }
        return count;
    }
    //==============================================================================================

    //==============================================================================================
    // Solution 2 :  Recursive Solution
    //==============================================================================================
    static int countTotalDigitRecursive(long n)
    {
        int total = 0;
        for(int i=1; i<=n; i++) {
            total += countDigitRecursive(i);
        }
        return total;
    }

    static int countDigitRecursive(long n)
    {
        if (n == 0)
            return 0;
        return 1 + countDigitRecursive(n / 10);
    }
    //==============================================================================================

    //==============================================================================================
    // Solution 3 :  Log based Solution
    //==============================================================================================
    static int countTotalDigitLogarithmic(long n)
    {
        int total = 0;
        for(int i=1; i<=n; i++) {
            total += countDigitLogarithmic(i);
        }
        return total;
    }

    static int countDigitLogarithmic(long n)
    {
        return (int)Math.floor(Math.log10(n) + 1);
    }
    //==============================================================================================

    //==============================================================================================
    // Solution 4 :  Converted String Solution
    //==============================================================================================
    static int countTotalDigitAsString(long n)
    {
        int total = 0;
        for(int i=1; i<=n; i++) {
            total += countDigitAsString(i);
        }
        return total;
    }

    static int countDigitAsString(long n)
    {
        return Long.toString(n).length();
    }
    //==============================================================================================


}
