import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class TestCase {

    private static int[] dp;

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        int[] count = new int[256];
        for (char c : t.toCharArray()) {
            count[c]++;
        }

        int start = 0, end = 0, startIdx = 0;
        int len = t.length();
        int minlen = Integer.MAX_VALUE;

        while (end < s.length()) {
            if (count[s.charAt(end)] > 0) {
                len--;
            }

            count[s.charAt(end++)]--;

            while (len == 0) {
                // minlen = Math.min(end - start + 1, minlen);
                System.out.println("The end is: " + end);
                if (minlen > end - start){
                    minlen = end - start;
                    startIdx = start;
                    System.out.println(startIdx + " " + end);
                }

                char c = s.charAt(start);
                if (count[c] == 0) {
                    len++;
                }
                count[c]++;
                start++;
                System.out.println("The start is: " + start);
                

            }
        }

    }

    public static void Bad() {
        throw new Error();
    }
}
