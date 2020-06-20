package String;

import java.util.Arrays;

public class CompareVersionNumbers165 {

    public static void main(String[] args) {
        String ls = "1.01";
        String ls2 = "1.001";

        System.out.println(compareVersion(ls,ls2));

    }

    public static int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        System.out.println(Arrays.toString(nums2));
        int len1 = nums1.length;
        int len2 = nums2.length;

        for (int i = 0; i < Math.max(len1, len2); i++) {
            int i1 = i < len1 ? Integer.parseInt(nums1[i]) : 0;
            int i2 = i < len2 ? Integer.parseInt(nums2[i]) : 0;
            System.out.println(i1 + ", " + i2);
            if (i1 != i2)
                return i1 > i2 ? 1 : -1;
        }

        return 0;
    }
}
