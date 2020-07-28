package Interview;

import java.util.*;

public class ObjectList {
    public static void main (String[] args) {
        //  [[1, 2], 3, [4, 5, 6], 7, 8]
        //  Integer
        List<Object> aList = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        aList.add(list1);
        aList.add(3);
        aList.add(list2);
        aList.add(7);
        aList.add(8);

        String result = traverseNestedList(aList);
        System.out.println(result); // 1 2 3 4 5 6 7 8
    }

    private static String traverseNestedList(List<Object> aList) {
// code
        int start = 0;
        int end = aList.size();
        List<Integer> temp = new ArrayList<>();
        while (start < end) {
            if (aList.get(start) instanceof List) {
                List<Object> tempList = (List<Object>) aList.get(start);
                for (Object i : tempList) {
                    temp.add((Integer) i);
                }
                start++;
            }else if(aList.get(start) instanceof Integer) {
                temp.add((Integer)aList.get(start++));
            }
        }

        return temp.toString();
    }
}
