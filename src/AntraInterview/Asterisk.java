package AntraInterview;

/**
 *  *  Insert asterisk between different characters in a given String.
 *  *    eg, Input = "aabbcde", output = "aa*bb*c*d*e"
 *  *    use recursion.
 */
public class Asterisk {
    public static void main(String[] args) {
        String s = "aabbcde";
        StringBuilder sb = new StringBuilder();
        recursion(s,0, 1, sb);
        String result = sb.toString();
        System.out.println(result);
    }

    public static void recursion (String s, int start, int end, StringBuilder result) {
        if (end == s.length()) {
            result.append(s.charAt(end - 1));
            return;
        }

        for (int i = end; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                String sub = s.substring(start, i) + "*";
                result.append(sub);
                recursion(s, i, i + 1, result);
                break;
            }
        }
    }
}
