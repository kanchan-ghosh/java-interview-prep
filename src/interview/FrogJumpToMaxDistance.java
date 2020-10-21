/**
 *
 * There are N blocks, numbered 0 to N-1, arranged in a row. A Couple of frogs were sitting together
 * on one block when they had a terrible quarrel. Now they want to jump away from one aother so that
 * the distance between them will be as large as possible. The distance between blocks
 * numbered J and K, where J <= K, is computed as K-J+1.
 * The frogs can only jump up, meaning that they can move from one block to another only if the two blocks
 * are adjacent and the second block is of the same or greater height as the first. WHat is the longest
 * distancce that they can possibly create between each other, if they also choose to sit on the optimal
 * starting block initially ?
 *
 * write a function:
 * 	class Solution {
 * 		public int solution(int[] blocks);
 *        }
 *
 * that, given an array blocks consisting of N integers denoting the heights of the blocks, returns
 * the longest possible distance that two frogs can make between each other starting from one of the
 * blocks.
 *
 * Example:
 *
 * 1. Given blocks=[2,6,8,5] the function should return 3. starting from blocks[0], the first frog
 * can stay where it is and the second frog can jump to blocks[2] (but not to blocks[3]).
 *
 * 2. Given blocks=[1,5,5,2,6] the function should return 4. If starting from blocks[3], the first
 * frog can jump to blocks[1], but not blocks[0], and the second frog can jump to blocks[4].
 *
 * 3. Given blocks=[1,1] the function should return 2. If starting from blocks[1], the first frog
 * can jump to blocks[0] and the second frog can stay where it is. Starting from blocks[0] woulld
 * result in same distance.
 *
 * write an efficient algorithm for the following asssumptions:
 * 	. N is an integer within the range [2..200,000]
 * 	. each element of array blocks is an integer within the range [1..1,000,000,000]
 *
 */

package interview;

public class FrogJumpToMaxDistance {
    public static void main(String[] args) {
        FrogJumpToMaxDistance ct = new FrogJumpToMaxDistance();

        int[] inp1 = new int[] {2,6,8,5};
        System.out.println(ct.solution(inp1));

        int[] inp2 = new int[] {1,5,5,2,6};
        System.out.println(ct.solution(inp2));

        int[] inp3 = new int[] {1,1};
        System.out.println(ct.solution(inp3));

        int[] inp4 = new int[] {1,7,6,5,2,3,4,8,9,6,8};
        System.out.println(ct.solution(inp4));

        int[] inp5 = new int[] {12,0,6,9,4,7,3,2,5,10};
        System.out.println(ct.solution(inp5));
    }

    public int solution(int[] blocks) {
        int max_distance = 0;
        int forward_distance = 0;
        int backward_distance = 0;
        for (int i = 0; i < blocks.length; i++) {
            int forward_move = i + 1;
            int backward_move = i - 1;
            while (forward_move < blocks.length && blocks[forward_move - 1] <= blocks[forward_move]) {
                forward_distance++;
                forward_move++;
            }
            while (backward_move >= 0 && blocks[backward_move + 1] <= blocks[backward_move]) {
                backward_distance++;
                backward_move--;
            }
            if (max_distance < forward_distance + backward_distance) {
                max_distance = forward_distance + backward_distance;
            }
            forward_distance = 0;
            backward_distance = 0;
        }

        return max_distance + 1;
    }
}
