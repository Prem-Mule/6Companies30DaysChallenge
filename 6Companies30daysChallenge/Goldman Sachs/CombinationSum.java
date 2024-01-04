import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void generate(List<List<Integer>> result, List<Integer> current, int sum, int count, int start) {
        if (count == 1 && start <= sum && sum <= 9) {
            current.add(sum);
            result.add(new ArrayList<>(current));
            current.remove(Integer.valueOf(sum));
            return;
        }
        for (int i = start; i < 9; i++) {
            if (i <= sum && sum - i > i) {
                current.add(i);
                generate(result, current, sum - i, count - 1, i + 1);
                current.remove(Integer.valueOf(i));
            } else {
                break;
            }
        }
    }

    public static List<List<Integer>> combinationSum(Integer sum, Integer count) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generate(result, current, sum, count, 1);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum(9, 3);
        for (List<Integer> a : result) {
            System.out.println(a.toString());
        }
    }
}
