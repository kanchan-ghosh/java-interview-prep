/**
 *
 * You are given a string S. Deletion of the K-th letter of S Cost C[K].
 * After deleting a letter, the cost of deleting other letter do not change.
 * For example for S = "ab" and C=[1,3], after deleting 'a', deletion of 'b' will still cost 3.
 *
 * You want to delete some letter from S to obtain a string without two identical letter next to each other.
 * What is the minimum total cost of deletion to achieve such a string ?
 *
 * Write a function:
 * 	class Solution {
 * 		public int solution(String S, int[] C);
 *        }
 *
 * that given string S and array C of integers, both of length N, returns the minimum cost of all
 * necessary deletions.
 *
 * Example:
 * ==========
 * 1. Given S = "abccbd" and C=[0,1,2,3,4,5], the function should return 2.
 * 	You can delete the first occurance of 'c' to achieve "abcbd".
 *
 * 2. Given S = "aabbcc" and C=[1,2,1,2,1,2] the function should return 3, By deleting all letters
 * 	with cost of 1, you can achieve string "abc".
 *
 * 3. Given S = "aaaa" and C=[3,4,5,6] the function should return 12. You need to delete all but one
 * 	letter 'a', and the lowest cost of deletion is 3+4+5 =12.
 *
 * 4. Given S = "ababa" and C=[10,5,10,5,10] the function should return 0. There is no need to
 * 	delete any letter.
 *
 * Write an efficient algorithm for the following assumptions:
 * 	. string S and array C have length equal N
 * 	. N is an integer within range [1..100,000]
 * 	. string S consists only of lowercase letters ('a'-'z')
 * 	. each element of array C is an integer within range [0..1000]
 *
 *
 */

package interview;

public class RemoveConsequentCharFromString {
    public static void main(String[] args) {
        RemoveConsequentCharFromString co = new RemoveConsequentCharFromString();
        String S1 = "abccbd";
        int[] c1 = new int[] {0,1,2,3,4,5};
        System.out.println(co.solution(S1, c1 ));

        String S2 = "aabbcc";
        int[] c2 = new int[] {1,2,1,2,1,2};
        System.out.println(co.solution(S2, c2));

        String S3 = "aaaa";
        int[] c3 = new int[] {3,4,5,6};
        System.out.println(co.solution(S3, c3));
    }

    public int solution(String S, int[] C) {
        int length = S.length();
        int cost = 0;
        char[] charArray = S.toCharArray();
        if (length < 2) {
            return cost;
        }

        int j = 0;
        for (int i = 1; i < length; i++) {
            if (charArray[j] != charArray[i]) {
                j++;
                charArray[j] = charArray[i];
            } else {
                cost += Math.min(C[i], C[i-1]);
            }
        }
        return cost;
    }
}
