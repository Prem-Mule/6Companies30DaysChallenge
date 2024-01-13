public class FollowingNumberPattern {
    public static String printNumberPattern(String s) {
        String result = "";
        int curr = 1;
        int dcount = 0;
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == 'I' && i == 0) {
                result += curr;
                curr++;
            }
            if (ch == 'D') {
                dcount++;
            }
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == 'D') {
                dcount++;
                j++;
            }
            int k = dcount;
            while (dcount >= 0) {
                result += (curr + dcount);
                dcount--;
            }
            curr += (k + 1);
            dcount = 0;
            i = j;
        }
        return result;
    }

    public static void main(String[] args) {
        String pattern = printNumberPattern("DDID");
        System.out.println(pattern);
    }
}
/*
 * Given a pattern containing only I's and D's. I for increasing and D for
 * decreasing. Devise an algorithm to print the minimum number following that
 * pattern. Digits from 1-9 and digits can't repeat.
 * 
 * Example 1:
 * 
 * Input:
 * D
 * Output:
 * 21
 * Explanation:
 * D is meant for decreasing, so we choose the minimum number among all possible
 * numbers like 21,31,54,87,etc.
 * Example 2:
 * 
 * Input:
 * IIDDD
 * Output:
 * 126543
 * Explanation:
 * Above example is self- explanatory,
 * 1 < 2 < 6 > 5 > 4 > 3
 * I - I - D - D - D
 * Your Task:
 * 
 * You don't need to read input or print anything. Your task is to complete the
 * function printMinNumberForPattern() which takes the string S and returns a
 * string containing the minimum number following the valid number.
 * 
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(1)
 */