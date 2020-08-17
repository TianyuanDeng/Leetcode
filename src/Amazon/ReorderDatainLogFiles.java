package Amazon;

import java.util.*;

public class ReorderDatainLogFiles {
    public static void main(String[] args) {
        String[] los = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        Solution res = new Solution();
        System.out.println(Arrays.toString(res.reorderLogFiles(los)));
    }
}

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] list1 = a.split(" ", 2);
            String[] list2 = b.split(" ", 2);

            boolean isDig1 = Character.isDigit(list1[1].charAt(0));
            boolean isDig2 = Character.isDigit(list2[1].charAt(0));

            if (!isDig1 && !isDig2) {
                int res = list1[1].compareTo(list2[1]);
                if (res == 0) {
                    return list1[0].compareTo(list2[0]);
                }else {
                    return res;
                }
            }else if (isDig1 && isDig2) {
                return 0;
            }else if (isDig1 && !isDig2) {
                return 1;
            }else {
                return -1;
            }
        });

        return logs;
    }
}
