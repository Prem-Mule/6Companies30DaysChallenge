import java.util.Set;
import java.util.HashSet;

public class KdivisibleElementSubarray {
    public static void countDistinct(int[] nums, int divisor, int limit) {

        int size = nums.length;
        Set<Long> hset = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int count = 0;
            Long hc = 1L;
            for (int j = i; j < size; j++) {
                hc = 199L * hc + nums[j];
                if (nums[j] % divisor == 0) {
                    count++;
                }
                if (count <= limit) {
                    hset.add(hc);
                }
            }
        }
        System.out.println("Total Combinations of Distinct Subarray: " + hset.size());
    }

    public static void main(String[] args) {
        int[] array = { 2, 3, 3, 2, 2 };
        countDistinct(array, 2, 2);
    }

}
/**
 * Given an integer array nums and two integers k and p, return the number of
 * distinct subarrays, which have at most k elements that are divisible by p.
 * 
 * Two arrays nums1 and nums2 are said to be distinct if:
 * 
 * They are of different lengths, or
 * There exists at least one index i where nums1[i] != nums2[i].
 * A subarray is defined as a non-empty contiguous sequence of elements in an
 * array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,3,2,2], k = 2, p = 2
 * Output: 11
 * Explanation:
 * The elements at indices 0, 3, and 4 are divisible by p = 2.
 * The 11 distinct subarrays which have at most k = 2 elements divisible by 2
 * are:
 * [2], [2,3], [2,3,3], [2,3,3,2], [3], [3,3], [3,3,2], [3,3,2,2], [3,2],
 * [3,2,2], and [2,2].
 * Note that the subarrays [2] and [3] occur more than once in nums, but they
 * should each be counted only once.
 * The subarray [2,3,3,2,2] should not be counted because it has 3 elements that
 * are divisible by 2.
 */