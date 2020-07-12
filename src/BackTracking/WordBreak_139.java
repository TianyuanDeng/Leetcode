package BackTracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return breaker(s, new HashSet<>(wordDict), 0,  new Boolean[s.length()]);
    }

    public boolean breaker(String s, Set<String> set, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        for (int end = start + 1;  end <= s.length(); end++) {
            if (set.contains(s.substring(start, end)) && breaker(s, set, end, memo)) {
                return memo[start] = true;
            }
        }

        return memo[start] = false;
    }
}
