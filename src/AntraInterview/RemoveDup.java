package AntraInterview;

import java.util.Arrays;
import java.util.List;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Input: "bcabc"
 * Output: "abc"
 */
class RemoveDup {
    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(removeDuplicateLetters(s));
        int[] nums = {1,3,5,2,8,11,1,2,3,2,4,5};
        //int[] nums = {1,1,2};
        int[] start = (removeDuplicateNumbers(nums));
        for (int n : start) {
            System.out.println(n);
        }
    }

    public static String removeDuplicateLetters(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }

        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i <  s.length(); i++) {
            if (letters[i] > 0) {
                sb.append((char)(i + 'a'));
            }
        }

        String result = sb.toString();
        return result;
    }

    public static int[] removeDuplicateNumbers(int[] nums) {
        int start = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[start + 1] = nums[i];
                start++;
            }
        }
        start++;
        int[] result = new int[start];
        for (int i = 0; i < start; i++) {
            result[i] = nums[i];
        }

        return result;
    }
}
