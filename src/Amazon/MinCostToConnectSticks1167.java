/**
 * Example 1:
 *
 * Input: sticks = [2,4,3]
 * Output: 14
 * Example 2:
 *
 * Input: sticks = [1,8,3,5]
 * Output: 30
 */


package Amazon;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectSticks1167 {
    public static void main(String[] args) {
        Solution res = new Solution();
        int[] sticks = {2,4,3};
        System.out.println(res.connectSticks(sticks));
    }

    static class Solution {
        public int connectSticks(int[] sticks) {
            Queue<Integer> pq = new PriorityQueue<>();
            for (int s : sticks) {
                pq.offer(s);
            }

            int sum = 0;
            while (pq.size() > 1) {
                int two = pq.poll() + pq.poll();
                sum += two;
                pq.offer(two);
            }

            return sum;
        }
    }
}

