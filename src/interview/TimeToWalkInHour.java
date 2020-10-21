/**
 *
 * Adventure Time
 * -------------------
 * Finn wants to visit Jake at his lake house. Finn loves math and decided to only walk
 * 1,2,3,4 or 5 KM each hour. Help Finn find out  maximum number of hours he will spend
 * on his journey
 *
 * Input: The first line contains an integer N - The distance in KM to Jake's Lake house
 *
 * Output: A Single number - The minimum number of hours Finn has to spend walking
 *
 * Constraints: 1 <= N <= 10^6
 *
 * Example
 * ---------
 * 1.	Input = 5
 * 	    Output = 1
 *
 * 2.	Input = 12
 * 	    Output = 3
 *
 */

package interview;

public class TimeToWalkInHour {

    public static void main(String[] args) {
        int distance1 = 5;
        int distance2 = 67;
        System.out.println(" Total hour to travel " + distance1 + " will be " + getMinimumHourRequired(distance1));
        System.out.println(" Total hour to travel " + distance2 + " will be " + getMinimumHourRequired(distance2));

        System.out.println(" Total hour to travel " + distance1 + " will be " + getHourRequired(distance1));
        System.out.println(" Total hour to travel " + distance2 + " will be " + getHourRequired(distance2));
    }

    static int getHourRequired(int dis) {
        int total = 0;
        int temp = dis;
        for(int i=5; i >= 1; i--) {
            total += temp / i;
            if(temp % i > 0)
                temp = temp % i;
            else
                break;
        }
        return total;
    }

    static int getMinimumHourRequired(int distance) {
        int total = 0;
        int h5 = 0, r5 = 0, h4 = 0, r4 = 0, h3 = 0, r3 = 0, h2 = 0, r2 = 0, h1 = 0, r1 = 0;
        h5 = distance / 5;
        r5  = distance % 5;

        if(r5 > 0) {
            h4 = r5 / 4;
            r4 = r5 % 4;
            if(r4 > 0) {
                h3 = r4 / 3;
                r3 = r4 % 3;
                if(r3 > 0) {
                    h2 = r3 / 2;
                    r2 = r3 % 2;
                    if(r2 > 0) {
                        h1 = r2;
                    }
                }
            }
        }
        total = h5 + h4 + h3 + h2 + h1;
        return total;
    }
}
