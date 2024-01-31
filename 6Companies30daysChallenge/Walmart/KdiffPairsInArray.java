package Walmart;

import java.util.Arrays;
import java.util.HashMap;

/**
 * KdiffPairsInArray
 */
public class KdiffPairsInArray {
  static public int[] maxSubsequence(int[] nums, int k) {
    int temp[] = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      temp[i] = nums[i];
    }
    int res[] = new int[k];
    Arrays.sort(temp);
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i = temp.length - 1; i >= nums.length - k; i--) {
      if (hm.containsKey(temp[i])) {
        hm.put(temp[i], hm.get(temp[i]) + 1);
      } else {
        hm.put(temp[i], 1);
      }
    }

    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (j == k) {
        break;
      }
      if (hm.containsKey(nums[i])) {
        if (hm.get(nums[i]) == 1) {
          hm.remove(nums[i]);
        } else {
          hm.put(nums[i], hm.get(nums[i]) - 1);
        }
        res[j] = nums[i];
        j++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = { -1, -2, 3, 4 };
    int[] result = maxSubsequence(nums, 3);
    for (int a : result) {
      System.out.println(a);
    }
  }
}
/*
 * Given an array of integers nums and an integer k, return the number of unique
 * k-diff pairs in the array.
 * 
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are
 * true:
 * 
 * 0 <= i, j < nums.length
 * i != j
 * |nums[i] - nums[j]| == k
 * Notice that |val| denotes the absolute value of val.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of
 * unique pairs.
 * Example 2:
 * 
 * Input: nums = [1,2,3,4,5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4)
 * and (4, 5).
 * Example 3:
 * 
 * Input: nums = [1,3,1,5,4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 */