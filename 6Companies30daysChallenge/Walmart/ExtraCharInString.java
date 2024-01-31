package Walmart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExtraCharInString {
    static public int minExtraChar(String s, String[] dictionary) {
        final int n = s.length();
        Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                if (dictionarySet.contains(s.substring(j, i)))
                    dp[i] = Math.min(dp[i], dp[j]);

                else
                    dp[i] = Math.min(dp[i], dp[j] + i - j);

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetscode";
        String dictionary[] = { "leet", "code", "leetcode" };
        System.out.println(minExtraChar(s, dictionary));
    }
}

/*
 * you are given a 0-indexed string s and a dictionary of words dictionary. You
 * have to break s into one or more non-overlapping substrings such that each
 * substring is present in dictionary. There may be some extra characters in s
 * which are not present in any of the substrings.
 * 
 * Return the minimum number of extra characters left over if you break up s
 * optimally.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
 * Output: 1
 * Explanation: We can break s in two substrings: "leet" from index 0 to 3 and
 * "code" from index 5 to 8. There is only 1 unused character (at index 4), so
 * we return 1.
 */