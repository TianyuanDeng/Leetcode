package String;

import java.util.ArrayList;
import java.util.List;

public class Remove_Ivalid_Parentheses301 {
    public static void main(String[] args) {
        String s = "()())()";
        String r = new StringBuilder(s).reverse().toString();
        System.out.println(r);

        System.out.println(removeInvalidParentheses(s));

    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        backTrack(s, ans, 0, 0, '(', ')');
        return ans;
    }

    public static void backTrack(String s, List<String> ans, int last_i, int last_j, char startP, char endP) {
        for (int stack = 0, i = last_i; i < s.length() ; i++) {
            if (s.charAt(i) == startP) stack++;
            if (s.charAt(i) == endP) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == endP && (j == last_j || s.charAt(j - 1) != endP)) {
                    backTrack(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, startP, endP);
                }
            }
            return;
        }
        System.out.println(s);

        String reverse = new StringBuilder(s).reverse().toString();

        if (startP == '(') {
            backTrack(reverse, ans, 0, 0, ')', '(');
        }else {
            ans.add(reverse);
        }
    }
}
