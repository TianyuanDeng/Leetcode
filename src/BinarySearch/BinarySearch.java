package BinarySearch;

import java.sql.SQLOutput;
import java.util.Arrays;

public class BinarySearch {

    /** 时间空间都是 O（logn)
     * 递归写法
     * @param nums
     * @param low
     * @param high
     * @param target
     * @return
     */

    public static int binarySeacrh(int[] nums, int low, int high, int target) {
        if (high < low) return -1;
        int mid  = (high - low) / 2 + low ;

        if (nums[mid] > target) {
            return binarySeacrh(nums, low, mid, target);
        } else if (nums[mid] < target) {
            return binarySeacrh(nums, mid + 1, high, target);
        } else {
            return mid;
        }
    }

    /**
     * 迭代写法
     * 如果没有找到target
     * right < target < left
     * right + 1 = left
     * 错位的
     */

    public static int binarySearch_Iterate(int nums[], int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                return mid;
            }

            System.out.println("mid: " + nums[mid] + "left: " + nums[left] + "right: " + nums[right]);
        }

        return -1;
    }

    /**
     * 迭代 <
     * target < left  = right
     * left = right
     *
     * 如果是rotate找最小值，可以set right = n.len - 1; cause at end , it will return left;
     * 用left边界最后停留位置来解题
     * @param nums
     * @param target
     * @return
     */

    public static int binarySearch_Iterate2(int nums[], int target) {
        int left = 0, right = nums.length;

        while (left < right) { //[left, right) left = right 结束
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) { //[left, mid)
                right = mid; //因为是开区间所以取不到right ,不能用 mid - 1;
            }else if (nums[mid] < target) { //[mid + 1, rihgt)
                left = mid + 1;
            }else {
                return mid;
            }

            System.out.println("mid: " + nums[mid] + "left: " + nums[left] + "rightIdx: " + right);
        }

        return -1;
    }

    /**
     * 迭代 left + 1 < right
     * target < left < right
     * left + 1 = right
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch_Iterate3(int nums[], int target) {
        int left = 0, right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            }else if (nums[mid] < target) {
                left = mid;
            }else {
                return mid;
            }

            System.out.println("mid: " + nums[mid] + "left: " + nums[left] + "rightIdx: " + right);
        }

        System.out.println("第三种 left:" + left + " right:" + right);
        if (target == nums[left]) return left;
        else if (target == nums[right]) return right;

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 9, 11, 0, 0};
        int[] temp = new int[10];
        for (int t : temp) {
            System.out.println(t);
        }

//        binarySearch_Iterate3(nums, 9);
        System.out.println(Arrays.binarySearch(nums, 0, 5, 10));
    }
}
