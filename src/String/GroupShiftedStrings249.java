package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings249 {
    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strings) {
            int idx = str.charAt(0) - 'a';
            String key = "";

            for (int i = 0; i < str.length(); i++) {
                char c = (char)(str.charAt(i) - idx);
                System.out.println(c);
                if (c < 'a') c += 26;
                System.out.println(c);
                key += c;
            }
            System.out.println(key);

            if (!map.containsKey(key)) {
                List<String> lst = new ArrayList<>();
                map.put(key, lst);
            }
            map.get(key).add(str);
        }

        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] s = {"abc, bcd", "acef", "xyz", "az", "ba", "a", "z"};
        String[] s2 = {"cde", "xyz"};


        groupStrings(s2);
    }
}
