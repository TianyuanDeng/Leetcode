package Interview;

public class KthLargest {
    public static void main(String[] args) {
        int[] nums = {1,3,4,5,6};
        int[] numsUnsorted = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 3));
        System.out.println(findUnsortedLargest(numsUnsorted, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        int result = 0;
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            result = nums[i];
        }

        return result;
    }

    public static int findUnsortedLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int helper(int[] nums, int start, int end, int k) {
        if (start == end) return nums[start];

        int pivot = nums[end];
        int pointer = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, pointer++);
            }
        }
        swap(nums, end, pointer);

        if (pointer == k)
            return nums[pointer];
        else if (pointer < k)
            return helper(nums, pointer + 1, end, k);
        else
            return helper(nums, start, pointer - 1, k);
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
