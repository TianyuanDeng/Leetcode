package Interview;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Input: "bcabc"
 * Output: "abc"
 */

class RemoveDup {
    public static void main(String[] args) {
        String s = "cdadabcc";
        System.out.println(removeDuplicateLetters2(s));
        int[] nums = {1,3,5,2,8,11,1,2,3,2,4,5};
        System.out.println(Arrays.toString(removeDuplicateNumbers(nums)));
    }

    //lexicographical order
    public static String removeDuplicateLetters(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }

        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i <  letters.length; i++) {
            if (letters[i] > 0) {
                sb.append((char)(i + 'a'));
            }
        }

        return sb.toString();
    }

    /**
     *
     * Input: "cbacdcbc"
     * output: "acdb"
     */
    public static String removeDuplicateLetters2(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] occur = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (occur[c - 'a']) continue;

            while (!stack.isEmpty() && stack.peek() > c && letters[stack.peek() - 'a'] > i) {
                occur[c - 'a'] = false;
                stack.pop();
            }

            stack.push(c);
            occur[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
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
        System.out.println(Arrays.toString(nums));

        start++;
        int[] result = new int[start];
        System.arraycopy(nums, 0, result, 0, start);

        return result;
    }
}
