import java.util.Arrays;

public class MinCost2StringConversion {

    static public long minimumCost(String inputText, String desiredText, char[] fromLetters, char[] toLetters,
            int[] transformationCost) {
        int alphabetSize = 26;
        int[][] transformationMatrix = new int[alphabetSize][alphabetSize];

        for (int idx = 0; idx < alphabetSize; idx++) {
            Arrays.fill(transformationMatrix[idx], Integer.MAX_VALUE);
            transformationMatrix[idx][idx] = 0;
        }

        int i = 0;
        while (i < fromLetters.length) {
            int origChar = fromLetters[i] - 'a';
            int newChar = toLetters[i] - 'a';
            int changeCost = transformationCost[i];

            transformationMatrix[origChar][newChar] = Math.min(transformationMatrix[origChar][newChar], changeCost);
            i++;
        }

        int k = 0;
        do {
            for (int row = 0; row < alphabetSize; row++) {
                for (int col = 0; col < alphabetSize; col++) {
                    if (transformationMatrix[row][k] != Integer.MAX_VALUE
                            && transformationMatrix[k][col] != Integer.MAX_VALUE) {
                        transformationMatrix[row][col] = Math.min(transformationMatrix[row][col],
                                transformationMatrix[row][k] + transformationMatrix[k][col]);
                    }
                }
            }
            k++;
        } while (k < alphabetSize);

        long totalCost = 0;
        for (int pos = 0; pos < inputText.length(); pos++) {
            int startChar = inputText.charAt(pos) - 'a';
            int endChar = desiredText.charAt(pos) - 'a';
            if (startChar == endChar) {
                continue;
            }
            if (transformationMatrix[startChar][endChar] == Integer.MAX_VALUE) {
                return -1;
            } else {
                totalCost += transformationMatrix[startChar][endChar];
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        String source = "aaaa";
        String target = "bbbb";
        char original[] = { 'a', 'c' };
        char changed[] = { 'c', 'b' };
        int[] cost = { 1, 2 };
        System.out.println(minimumCost(source, target, original, changed, cost));
    }
}

/*
 * You are given two 0-indexed strings source and target, both of length n and
 * consisting of lowercase English letters. You are also given two 0-indexed
 * character arrays original and changed, and an integer array cost, where
 * cost[i] represents the cost of changing the character original[i] to the
 * character changed[i].
 * 
 * You start with the string source. In one operation, you can pick a character
 * x from the string and change it to the character y at a cost of z if there
 * exists any index j such that cost[j] == z, original[j] == x, and changed[j]
 * == y.
 * 
 * Return the minimum cost to convert the string source to the string target
 * using any number of operations. If it is impossible to convert source to
 * target, return -1.
 * 
 * Note that there may exist indices i, j such that original[j] == original[i]
 * and changed[j] == changed[i].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: source = "abcd", target = "acbe", original =
 * ["a","b","c","c","e","d"], changed = ["b","c","b","e","b","e"], cost =
 * [2,5,5,1,2,20]
 * Output: 28
 * Explanation: To convert the string "abcd" to string "acbe":
 * - Change value at index 1 from 'b' to 'c' at a cost of 5.
 * - Change value at index 2 from 'c' to 'e' at a cost of 1.
 * - Change value at index 2 from 'e' to 'b' at a cost of 2.
 * - Change value at index 3 from 'd' to 'e' at a cost of 20.
 * The total cost incurred is 5 + 1 + 2 + 20 = 28.
 * It can be shown that this is the minimum possible cost.
 * Example 2:
 * 
 * Input: source = "aaaa", target = "bbbb", original = ["a","c"], changed =
 * ["c","b"], cost = [1,2]
 * Output: 12
 * Explanation: To change the character 'a' to 'b' change the character 'a' to
 * 'c' at a cost of 1, followed by changing the character 'c' to 'b' at a cost
 * of 2, for a total cost of 1 + 2 = 3. To change all occurrences of 'a' to 'b',
 * a total cost of 3 * 4 = 12 is incurred.
 */