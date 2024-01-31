public class CountNiceSubArrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return countOddSlidingWindow(nums, k) - countOddSlidingWindow(nums, k - 1);
    }

    static int countOddSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int si = 0;
        int sum = 0;
        int count = 0;
        for (int cur = 0; cur < n; cur++) {
            if (arr[cur] % 2 != 0)
                sum++;
            if (sum <= k)
                count += cur - si + 1;
            while (si <= cur && sum > k) {
                if (arr[si] % 2 != 0) {
                    sum--;
                }
                si++;
                if (sum <= k)
                    count += cur - si + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = { 1, 1, 2, 1, 1 };
        System.out.println(countOddSlidingWindow(array, 3));
    }
}
/*
 * Given an array of integers nums and an integer k. A continuous subarray is
 * called nice if there are k odd numbers on it.
 * 
 * Return the number of nice sub-arrays.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and
 * [1,2,1,1].
 * Example 2:
 * 
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There is no odd numbers in the array.
 */
