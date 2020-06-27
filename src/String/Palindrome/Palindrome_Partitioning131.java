package String.Palindrome;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 一定要注意idx和i的关系，不要用错了
 */


public class Palindrome_Partitioning131 {
    public static List<List<String>> ans;
    public static List<String> temp;

    public static void main(String[] args) {
        String s= "aab";
        partition(s);
    }

    public static List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();

        backTracking(s, 0);
        return ans;
    }

    public static void backTracking(String s, int idx) {
        if (temp.size() != 0 && idx == s.length()) {
            ans.add(new ArrayList(temp));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                if (i == idx) {
                    temp.add(Character.toString(s.charAt(i)));
                }else {
                    temp.add(s.substring(idx, i + 1));
                }

                backTracking(s, i + 1);
                System.out.println(temp.get(temp.size() - 1));
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}
