package Adobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstrainedSubseqSum {
    static public int constrainedSubsetSum(int[] nums, int k) {
        // Initialize variables
        int res = nums[0];
        Deque<Integer> q = new ArrayDeque<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; ++i) {
            // Update current element based on deque's front
            nums[i] += !q.isEmpty() ? q.peek() : 0;
            res = Math.max(res, nums[i]);

            // Maintain a decreasing order in the deque
            while (!q.isEmpty() && nums[i] > q.peekLast())
                q.pollLast();
            if (nums[i] > 0)
                q.offer(nums[i]);

            // Remove elements that violate the constraint
            if (i >= k && !q.isEmpty() && q.peek() == nums[i - k])
                q.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 2, -10, 5, 20 };
        System.out.println(constrainedSubsetSum(nums, 2));
    }
}
/*
 * Given an integer array nums and an integer k, return the maximum sum of a
 * non-empty subsequence of that array such that for every two consecutive
 * integers in the subsequence, nums[i] and nums[j], where i < j, the condition
 * j - i <= k is satisfied.
 * 
 * A subsequence of an array is obtained by deleting some number of elements
 * (can be zero) from the array, leaving the remaining elements in their
 * original order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [10,2,-10,5,20], k = 2
 * Output: 37
 * Explanation: The subsequence is [10, 2, 5, 20].
 * Example 2:
 * 
 * Input: nums = [-1,-2,-3], k = 1
 * Output: -1
 * Explanation: The subsequence must be non-empty, so we choose the largest
 * number.
 */