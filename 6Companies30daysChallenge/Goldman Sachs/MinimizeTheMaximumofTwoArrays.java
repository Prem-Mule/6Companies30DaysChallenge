public class MinimizeTheMaximumofTwoArrays {
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long l = 1, r = (int) (2 * 1e9);
        long ans = r;

        long lcm = (1L * divisor1 * divisor2) / gcd(divisor1, divisor2);

        for (; l <= r;) {
            long mid = (l + r) >> 1;
            long x = mid - mid / divisor1;
            long y = mid - mid / divisor2;
            long z = mid - mid / lcm;

            if (x < 1L * uniqueCnt1 || y < 1L * uniqueCnt2 || z < 1L * (uniqueCnt1 + uniqueCnt2))
                l = mid + 1;
            else {
                ans = Math.min(ans, mid);
                r = mid - 1;
            }
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(minimizeSet(2, 7, 1, 3));
    }
}

/*
 * We have two arrays arr1 and arr2 which are initially empty. You need to add
 * positive integers to them such that they satisfy all the following
 * conditions:
 * 
 * arr1 contains uniqueCnt1 distinct positive integers, each of which is not
 * divisible by divisor1.
 * arr2 contains uniqueCnt2 distinct positive integers, each of which is not
 * divisible by divisor2.
 * No integer is present in both arr1 and arr2.
 * Given divisor1, divisor2, uniqueCnt1, and uniqueCnt2, return the minimum
 * possible maximum integer that can be present in either array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: divisor1 = 2, divisor2 = 7, uniqueCnt1 = 1, uniqueCnt2 = 3
 * Output: 4
 * Explanation:
 * We can distribute the first 4 natural numbers into arr1 and arr2.
 * arr1 = [1] and arr2 = [2,3,4].
 * We can see that both arrays satisfy all the conditions.
 * Since the maximum value is 4, we return it.
 * Example 2:
 * 
 * Input: divisor1 = 3, divisor2 = 5, uniqueCnt1 = 2, uniqueCnt2 = 1
 * Output: 3
 * Explanation:
 * Here arr1 = [1,2], and arr2 = [3] satisfy all conditions.
 * Since the maximum value is 3, we return it.
 */