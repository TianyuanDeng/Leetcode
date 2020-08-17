package Amazon;

import java.util.*;

public class AnalyzeUser1152 {
    public static void main(String[] args) {
        String[] username = {"u1","u1","u1","u2","u2","u2"};

        int[] timestamp = {1,2,3,4,5,6};
        String[] website = {"a","b","c","a","b","a"};

        System.out.println(mostVisitedPattern(username, timestamp, website));
    }

    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, StringBuilder> map = new HashMap<>();
        int counter = 1;
        Arrays.sort(timestamp);
        for (int i = 0; i < username.length; i ++) {
            String name = username[i];
            if (map.containsKey(name)) {
                if (counter == 3) {
                    continue;
                }else {
                    map.get(name).append(website[i]).append(" ");
                    counter++;
                }
            }else {
                counter = 1;
                StringBuilder sb = new StringBuilder();
                sb.append(website[i]).append(" ");
                map.put(name, sb);
            }
        }

        Map<StringBuilder, Integer> count = new HashMap<>();
        for (String str : map.keySet()) {
            System.out.println("str is: " + str + ", value is: " + map.get(str));
            StringBuilder sb = map.get(str);
            count.put(sb, count.getOrDefault(sb, 0) + 1);
        }

        List<StringBuilder> list = new ArrayList<>(count.keySet());
        list.sort((a, b) -> count.get(a).equals(count.get(b)) ? a.compareTo(b) : count.get(a) - count.get(b));
        //list.sort(StringBuilder::compareTo);


        String[] res = list.get(0).toString().split(" ");
        List<String> result = new ArrayList<>();
        Collections.addAll(result, res);

        return result;
    }
}
