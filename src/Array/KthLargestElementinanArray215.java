package Array;

public class KthLargestElementinanArray215 {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, nums.length - k);    
    }

    private int helper(int[] nums, int start, int end, int k) {
        if (start == end) return nums[start];
        
        int mid = nums[end];
        int pointer = start;
        // i应该等于 start, i < end
        for (int i = start; i < end; i++) {
            if (nums[i] <= mid) {
                swap(nums, i, pointer++);
            }
        }
        swap(nums, pointer, end);

        if (pointer == k) {
            return nums[pointer];
        }else if (pointer < k) {
            return helper(nums, pointer + 1, end, k);
        }else{
            return helper(nums, start, pointer - 1, k);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
