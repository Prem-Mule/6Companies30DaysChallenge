import java.util.Arrays;

public class waysToReachPosition {
    public static int findWays(int start, int end, int k) {
        int[][] dp = new int[2000][k + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helperFunction(start, end, k, dp);
    }

    public static int helperFunction(int start, int end, int k, int[][] dp) {
        if (start == end && k == 0) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        if (dp[start + 1000][k] != -1) {
            return dp[start + 1000][k];
        }
        int left = helperFunction(start - 1, end, k - 1, dp);
        int right = helperFunction(start + 1, end, k - 1, dp);
        dp[start + 1000][k] = (left + right) % ((int) 1e9 + 7);
        return dp[start + 1000][k];
    }

    public static void main(String[] args) {
        System.out.println(findWays(1, 2, 3));
    }
}
// You are given two positive integers startPos and endPos. Initially, you are
// standing at position startPos on an infinite number line. With one step, you
// can move either one position to the left, or one position to the right.

// Given a positive integer k, return the number of different ways to reach the
// position endPos starting from startPos, such that you perform exactly k
// steps. Since the answer may be very large, return it modulo 109 + 7.

// Two ways are considered different if the order of the steps made is not
// exactly the same.

// Note that the number line includes negative integers.

// Example 1:

// Input: startPos = 1, endPos = 2, k = 3
// Output: 3
// Explanation: We can reach position 2 from 1 in exactly 3 steps in three ways:
// - 1 -> 2 -> 3 -> 2.
// - 1 -> 2 -> 1 -> 2.
// - 1 -> 0 -> 1 -> 2.
// It can be proven that no other way is possible, so we return 3.
// Example 2:

// Input: startPos = 2, endPos = 5, k = 10
// Output: 0
// Explanation: It is impossible to reach position 5 from position 2 in exactly
// 10 steps.
