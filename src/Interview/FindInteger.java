package Interview;

import java.util.HashSet;
import java.util.Set;

/**
 * code是找出一个string中出现integer的个数
 * 比如"fsajfsld123eljfasldj2e12",
 * 这串字符中integer是3。
 */
public class FindInteger {
    public static void main(String[] args) {
        String s = "fsajfsld123eljfasldj2e12";
        System.out.println(helper(s));
    }

    public static int helper(String s) {
        Set<Character> nums = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                if (nums.add(s.charAt(i))) {
                    sb.append(s.charAt(i));
                }
            }
        }

        System.out.println(sb);
        return nums.size();
    }

}
