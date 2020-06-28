package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffWaysToAddParentheses241 {
    private static Map<String, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        String s = "2*3-4*5";
//        System.out.println(diffWaysToCompute(s));
        diffWaysToCompute(s);
    }

    public static List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) return map.get(input);
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                System.out.println("left: " + left + ", right: " + right);

                for (int m : left) {
                    for (int n : right) {
                        if (c == '+') {
                            res.add(m + n);
                        }else if (c == '-') {
                            res.add(m - n);
                        }else if (c == '*') {
                            res.add(m * n);
                        }
                    }
                }
            }
        }

        if (res.isEmpty()) {
            res.add(Integer.valueOf(input));
        }
        System.out.println(res + " " + input);
        map.put(input, res);
        return res;
    }
}
