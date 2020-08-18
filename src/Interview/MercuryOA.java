package Interview;

import java.util.Stack;

public class MercuryOA {
    public static void main(String[] args) {
        String s4 = "3[ab2[c]2[d2[e]f]]";
        String s3 = "1 / {1 + [(1 + 1) * 1]}";
        String s3Wrong = "[1 + {1 }] / 2";
        String temp = "2";
        int i = 0;
        i = temp.charAt(0) - '0';
        System.out.println(i);
    }

    public static String helperQ4(String s) {
        //use 2 stack, when meet '['，we put current stringbuilder and number in each stack
        //meet ']' pop the number stack, create a temp stringbuilder to store the string in
        //current, then use a for loop to copy it;
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            }else if (c == '[') {
                strStack.push(current);
                current = new StringBuilder();
                numStack.push(count);
                count = 0;
            }else if (c == ']') {
                StringBuilder temp = current;
                current = strStack.pop();
                for (int i = numStack.pop(); i > 0; i--) {
                    current.append(temp);
                }
            }else {
                current.append(c);
            }
        }

        return current.toString();
    }

    // s = "[1 + {1 ] / 2}";
    public static boolean helperQ3(String s) {
        //Only need to check if it's parenthesizes, so we just need a stack;
        //if char c is left side parenthesis, add related right part;
        //if isn't bracket just go to next one;
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            }else if (c == '{') {
                stack.push('}');
            }else if (c == '[') {
                stack.push(']');
            }else if ("{}[]()".indexOf(c) < 0) {
                continue;
            }else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
