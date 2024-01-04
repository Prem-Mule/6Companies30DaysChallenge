import java.util.Arrays;

class KthSmallestElemQuery {
    public static int[] smallestNumberQueries(String[] nums, int[][] queries) {
        int size = nums.length;
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            String[] trimmedNums = new String[size];
            for (int j = 0; j < size; j++) {
                trimmedNums[j] = nums[j].substring(nums[j].length() - trim);
            }
            Integer[] Indices = new Integer[nums.length];
            for (int j = 0; j < size; j++) {
                Indices[j] = j;
            }
            Arrays.sort(Indices, (a, b) -> trimmedNums[a].compareTo(trimmedNums[b]));
            answer[i] = Indices[k - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] nums = { "102", "473", "251", "814" };
        int[][] queries = { { 1, 1 }, { 2, 3 }, { 4, 2 }, { 1, 2 } };

        int[] result = smallestNumberQueries(nums, queries);

        System.out.println(Arrays.toString(result));
    }
}