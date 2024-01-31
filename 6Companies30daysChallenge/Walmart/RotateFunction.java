package Walmart;

public class RotateFunction {
    static public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int sum = 0, F0 = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            F0 += i * A[i];
        }
        int dp[] = new int[A.length];
        dp[0] = F0;
        max = dp[0];
        for (int i = 1; i < A.length; i++) {
            dp[i] = dp[i - 1] + sum - A.length * A[A.length - i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = { 4, 3, 2, 6 };
        System.out.println(maxRotateFunction(A));
    }
}
/*
 * package Walmart;
 * 
 * import java.util.ArrayList;
 * import java.util.Arrays;
 * import java.util.List;
 * 
 * public class LargestDivisionSubset {
 * static public List<Integer> largestDivisibleSubset(int[] nums) {
 * int n = nums.length;
 * int[] count = new int[n];
 * int[] pre = new int[n];
 * Arrays.sort(nums);
 * int max = 0, index = -1;
 * for (int i = 0; i < n; i++) {
 * count[i] = 1;
 * pre[i] = -1;
 * for (int j = i - 1; j >= 0; j--) {
 * if (nums[i] % nums[j] == 0) {
 * if (1 + count[j] > count[i]) {
 * count[i] = count[j] + 1;
 * pre[i] = j;
 * }
 * }
 * }
 * if (count[i] > max) {
 * max = count[i];
 * index = i;
 * }
 * }
 * List<Integer> res = new ArrayList<>();
 * while (index != -1) {
 * res.add(nums[index]);
 * index = pre[index];
 * }
 * return res;
 * }
 * 
 * public static void main(String[] args) {
 * int[] nums = { 1, 2, 3 };
 * List<Integer> result = largestDivisibleSubset(nums);
 * for (int a : result) {
 * System.out.println(a);
 * }
 * }
 * }
 */
