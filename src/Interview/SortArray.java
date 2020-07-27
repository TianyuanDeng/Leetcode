package Interview;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] nums = {6,1,2,3,4,5,2,1,3,6};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    static void quickSort(int[] nums, int start, int end) {
        int l = start;
        int r = end;
        int pivot = nums[start + (end - start) / 2];

        while (l <= r) {
            while (pivot > nums[l]) {
                l++;
            }

            while (pivot < nums[r]) {
                r--;
            }

            if (l <= r) {
                int temp = nums[l];
                nums[l++] = nums[r];
                nums[r--] = temp;
            }
        }

        if (start < r) quickSort(nums, start, r);
        if (l < end) quickSort(nums, l, end);
    }
}
