package String.Palindrome;

import java.util.*;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 */

public class Palindrome_Pairs336 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> wordSet = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordSet.put(words[i], i);
        }

        for (String w : wordSet.keySet()) {
            int curIdx = wordSet.get(w);
            String reversedW = new StringBuilder(w).reverse().toString();

            if (wordSet.containsKey(reversedW)) {
                ans.add(Arrays.asList(wordSet.get(reversedW), curIdx));
            }

            for (String prefix : allValidPrefixes(w)) {
                String reversedPre = new StringBuilder(prefix).reverse().toString();
                if (wordSet.containsKey(reversedPre)) {
                    ans.add(Arrays.asList(curIdx, wordSet.get(reversedPre)));
                }
            }

            for (String suffix : allValidSuffix(w)) {
                String reversedSuf = new StringBuilder(suffix).reverse().toString();
                if (wordSet.containsKey(reversedSuf)) {
                    ans.add(Arrays.asList(wordSet.get(reversedSuf), curIdx));
                }
            }
        }

        return ans;
    }
    private static List<String> allValidSuffix(String word) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(word, 0, i)) {
                list.add(word.substring(i + 1, word.length()));
            }
        }
        return list;
    }

    private static List<String> allValidPrefixes(String word) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(word, i, word.length() - 1)) {
                list.add(word.substring(0, i));
            }
        }
        return list;
    }

    private static boolean isPalindrome(String word, int start, int end) {
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
