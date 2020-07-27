package Interview;

import java.util.ArrayList;
import java.util.List;

public class StringReverse {
    public static void main(String[] args) {
        String s = "aaabcaddcccadda";
        int[] num = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        String temp = new StringBuilder(s).reverse().toString();
        System.out.println(temp);
        System.out.println(reverse(s));

        System.out.println(findUnique(s));

        System.out.println(findPrime(num));
        System.out.println(sieveOfEratosthenes(40));
    }

    public static String reverse(String s) {
        char[] c = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start != end) {
            char temp = c[start];
            c[start++] = c[end];
            c[end--] = temp;
        }

        return new String(c);
    }

    public static char findUnique(String s) {
        char[] input = s.toCharArray();
        char firstUnique = '\0';
        for (int i = 1; i < input.length; i++) {
            if (input[i] != input[i - 1]) {
                firstUnique = input[i];
                break;
            }
        }

        return firstUnique;
    }

    public static List<Integer> findPrime(int[] num) {
        List<Integer> output = new ArrayList<>();
        for (int number : num) {
            int count = 0;
            for (int n = number; n >= 1; n--) {
                if (number % n == 0) {
                    count++;
                }
            }

            if (count == 2) {
                output.add(number);
            }
        }

        return output;
        //return output.stream().mapToInt(i -> i).toArray();
    }

    public static List<Integer> sieveOfEratosthenes (int n) {
        List<Integer> out = new ArrayList<>();
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (prime[i])
                for (int j = i * 2; j <= n; j += i) {
                    prime[j] = false;
                }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i])
                out.add(i);
        }

        return out;
    }
}
