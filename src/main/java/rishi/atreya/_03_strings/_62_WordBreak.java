package rishi.atreya._03_strings;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _62_WordBreak {
    // dynamic programming
    public boolean wordBreak(String s, List<String> wordDict) {
        Set < String > wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // recursive
    public static boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
        if (start == s.length()) return true;
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))
                    && wordBreakRecur(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }
}
