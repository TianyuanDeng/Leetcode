package Array;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 *
 * 思路：
 * 两个指针的运用，难点在于结束的位置，用end来替代nums.length,从而终止后半部分的再排序；
 */
public class SortColors75 {


    class Solution {
        public void sortColors(int[] nums) {
            int start = 0, end = nums.length - 1;
            int i = 0;

            while (i <= end) {
                if (nums[i] == 0 && start < nums.length) {
                    int temp = nums[start];
                    nums[start++] = nums[i];
                    nums[i++] = temp;
                }else if (nums[i] == 2) {
                    int temp = nums[end];
                    nums[end--] = nums[i];
                    nums[i] = temp;
                }else {
                    i++;
                }
            }
        }
    }
}
