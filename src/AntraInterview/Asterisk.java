package AntraInterview;

/**
 *  *  Insert asterisk between different characters in a given String.
 *  *    eg, Input = "aabbcde", output = "aa*bb*c*d*e"
 *  *    use recursion.
 */
public class Asterisk {
    public static void main(String[] args) {
        String s = "aaaabbbbbcccdddd";
        StringBuilder sb = new StringBuilder();
        recursion(s,0, 1, sb);
        String result = sb.toString();
        System.out.println(result);
    }

    public static void recursion (String s, int start, int end, StringBuilder result) {

        for (int i = end; i < s.length(); i++) {
            System.out.println(i);
            if (s.charAt(i) != s.charAt(i - 1)) {
                String sub = s.substring(start, i) + "*";
                result.append(sub);
                recursion(s, i, i + 1, result);
                break;
            }else if (i == s.length() - 1 && s.charAt(i) == s.charAt(start)) {
                result.append(s.substring(start, s.length()));
            }
        }

       if (end == s.length()) {
            result.append(s.charAt(end - 1));
        }
    }
}
