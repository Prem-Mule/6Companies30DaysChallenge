public class FindMissingNumber {

    public static int[] findMissingandRepeatingNumber(int[] array, int size) {
        int m = 0, r = 0;
        int[] result = new int[2];
        int[] counts = new int[size];
        for (int i = 0; i < size; i++) {
            counts[array[i] - 1]++;
        }
        for (int i = 0; i < size; i++) {
            if (counts[i] == 0) {
                m = i + 1;
                result[1] = m;
            }
            if (counts[i] > 1) {
                r = i + 1;
                result[0] = r;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = { 1, 5, 3, 2, 7, 6, 5 };
        int[] answer = findMissingandRepeatingNumber(array, array.length);
        System.out.println("Repeating Number: " + answer[0] + "\nMissing number: " + answer[1]);
    }
}