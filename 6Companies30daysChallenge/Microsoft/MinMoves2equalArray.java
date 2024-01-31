import java.util.Random;

public class MinMoves2equalArray {
    static public int minMoves2(int[] nums) {
        int operations = 0, mid = quickSelect(nums, 0, nums.length - 1, nums.length / 2);
        for (int num : nums)
            operations += Math.abs(mid - num);
        return operations;
    }

    static private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right)
            return nums[left];

        int pIndex = new Random().nextInt(right - left + 1) + left;
        pIndex = partition(nums, left, right, pIndex);

        if (pIndex == k)
            return nums[k];
        else if (pIndex < k)
            return quickSelect(nums, pIndex + 1, right, k);
        return quickSelect(nums, left, pIndex - 1, k);
    }

    static private int partition(int[] nums, int left, int right, int pIndex) {
        int pivot = nums[pIndex];
        swap(nums, pIndex, right);
        pIndex = left;

        for (int i = left; i <= right; i++)
            if (nums[i] <= pivot)
                swap(nums, i, pIndex++);

        return pIndex - 1;
    }

    static private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 4, 6 };
        System.out.println(minMoves2(array));
    }
}
/*
 * Given an integer array nums of size n, return the minimum number of moves
 * required to make all array elements equal.
 * 
 * In one move, you can increment or decrement an element of the array by 1.
 * 
 * Test cases are designed so that the answer will fit in a 32-bit integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3]
 * Output: 2
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one
 * element):
 * [1,2,3] => [2,2,3] => [2,2,2]
 */