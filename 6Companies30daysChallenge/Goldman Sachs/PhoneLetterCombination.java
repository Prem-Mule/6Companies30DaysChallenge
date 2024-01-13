import java.util.ArrayList;
import java.util.List;

public class PhoneLetterCombination {

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        String[] keypad = { "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz" };
        backtrack("", digits, keypad, result);
        return result;
    }

    public static void backtrack(String combination, String next_digits, String[] keypad, List<String> result) {
        if (next_digits.isEmpty()) {
            result.add(combination);
        } else {
            String letters = keypad[next_digits.charAt(0) - '2'];
            for (char letter : letters.toCharArray()) {
                backtrack(combination + letter, next_digits.substring(1), keypad, result);
            }
        }
    }

    public static void main(String[] args) {
        List<String> answer = letterCombinations("828");
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
/*
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in any
 * order.
 * 
 * A mapping of digits to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 
 * Example 1:
 * 
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * 
 * Input: digits = ""
 * Output: []
 * Example 3:
 * 
 * Input: digits = "2"
 * Output: ["a","b","c"]
 */