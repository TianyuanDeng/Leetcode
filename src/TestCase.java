import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class TestCase {

    private static int[] dp;

    public static void main(String[] args) {
        int x = 121;
        String s = "()";
        Stack<Integer> stack = new Stack<>();
        int startIdx = -1;
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else {
                if(stack.isEmpty()) {
                    startIdx = i;
                }else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        System.out.println(startIdx);
                        len = Math.max(len, i - startIdx);
                    }else {
                        len = Math.max(len, i - stack.peek());
                    }
                }
            }
        }
    }

    public static String shortestPalindrome(String s) {
        int j = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
        }

        if (j == s.length()) return s;
        String suffix = s.substring(j);
        System.out.println(suffix + j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
}
