import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class TestCase {

    public static void main(String[] args) {

        String s = " the sky is    blue!";
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        String[] t = s.split(" ");
        Collections.reverse(list);

        String[] temp = {"3", "30", "34", "5", "9"};
//        Arrays.sort(temp, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                String order1 = a + b;
//                String order2 = b + a;
//                return order2.compareTo(order1);
//            }
//        });

//        Arrays.sort(temp, (a,b) -> {
//            String ord1 = a + b;
//            String ord2 = b + a;
//            return ord2.compareTo(ord1);
//        });
//        System.out.println(Arrays.asList(temp));
//
//        Arrays.sort(temp, (a,b) -> (a + b).compareTo(b + a));
//        System.out.println(Arrays.asList(temp));
//
//        String t1 = "12";
//        String t2 = "23";
//
//        int result = t1.compareTo(t2);
//
//        System.out.println(result);

        int[] nums = new int[]{3, 30, 34, 5, 9};
        String[] num = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            num[i] = String.valueOf(num[i]);
        }

        Arrays.sort(num, (a, b) -> (b + a).compareTo(a + b));
        System.out.println(Arrays.asList(num));

        String res = new String();
        for (String te : num) {
            res += te;
        }

        System.out.println(res);
    }
}
