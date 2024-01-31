package Adobe;

import java.util.Arrays;

public class SpecialPermutations {
    static int mod = 1000000007;

    static int sb(int x) {
        int ans = 0;
        while (x > 0) {
            if ((x & 1) == 1)
                ans++;
            x = x >> 1;
        }
        return ans;
    }

    static long[][] dp = new long[1 << 14][15];

    static int func(int idx, int[] nums, int mask, int prev) {
        if (idx == nums.length)
            return (sb(mask) == nums.length) ? 1 : 0;

        long way1 = 0;

        if (dp[mask][prev + 1] != -1)
            return (int) dp[mask][prev + 1];

        if (prev == -1) {
            for (int i = 0; i < nums.length; ++i) {
                if ((mask & (1 << i)) != 0)
                    continue;
                else {
                    int newMask = mask | (1 << i);
                    way1 = (way1 + func(idx + 1, nums, newMask, i)) % mod;
                }
            }
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if ((mask & (1 << i)) != 0)
                    continue;
                else {
                    if (nums[i] % nums[prev] == 0 || nums[prev] % nums[i] == 0) {
                        int newMask = mask | (1 << i);
                        way1 = (way1 + func(idx + 1, nums, newMask, i)) % mod;
                    }
                }
            }
        }

        return (int) (dp[mask][prev + 1] = way1 % mod);
    }

    static int specialPerm(int[] nums) {
        for (long[] row : dp)
            Arrays.fill(row, -1);

        int mask = 0;
        return func(0, nums, mask, -1) % mod;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 6 };
        System.out.println(specialPerm(nums));
    }
}
/*
 * You are given a 0-indexed integer array nums containing n distinct positive
 * integers. A permutation of nums is called special if:
 * 
 * For all indexes 0 <= i < n - 1, either nums[i] % nums[i+1] == 0 or nums[i+1]
 * % nums[i] == 0.
 * Return the total number of special permutations. As the answer could be
 * large, return it modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,6]
 * Output: 2
 * Explanation: [3,6,2] and [2,6,3] are the two special permutations of nums.
 */