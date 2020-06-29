import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class TestCase {

    private static int[] dp;

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int[] dp = new int[nums.length];

        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            System.out.println(i + ", nums: " + num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }

            System.out.println(len);
        }
    }
}
