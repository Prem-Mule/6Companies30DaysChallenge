public class RunLengthEncoding {
    public static String encode(String str) {
        String result = "";
        char c;
        int i = 0;
        int count;
        while (i < str.length()) {
            c = str.charAt(i);
            count = 0;
            while (i < str.length() && str.charAt(i) == c) {
                i++;
                count++;
            }
            result = result + c + count;

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(encode("aabbcccdc"));
    }
}
/*
 * Given a string, Your task is to complete the function encode that returns the
 * run length encoded string for the given string.
 * eg if the input string is “wwwwaaadexxxxxx”, then the function should return
 * “w4a3d1e1x6″.
 * You are required to complete the function encode that takes only one argument
 * the string which is to be encoded and returns the encoded string.
 * 
 * Example 1:
 * 
 * Input:
 * str = aaaabbbccc
 * Output: a4b3c3
 * Explanation: a repeated 4 times
 * consecutively b 3 times, c also 3
 * times.
 * Example 2:
 * 
 * Input:
 * str = abbbcdddd
 * Output: a1b3c1d4
 */