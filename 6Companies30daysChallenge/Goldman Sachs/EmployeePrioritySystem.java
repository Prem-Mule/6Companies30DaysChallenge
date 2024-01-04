import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EmployeePrioritySystem {
    public static List<String> find(List<List<String>> access_Times) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (List<String> access : access_Times) {
            map.computeIfAbsent(access.get(0), v -> new ArrayList<>()).add(Integer.valueOf(access.get(1)));
        }
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
            if (map.get(key).size() < 2) {
                continue;
            }
            for (int i = 0; i < map.get(key).size() - 2; i++) {
                if (map.get(key).get(i + 1) - map.get(key).get(i) < 100
                        && map.get(key).get(i + 2) - map.get(key).get(i) < 100) {
                    result.add(key);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<List<String>> accessTimes = new ArrayList<>();
        accessTimes.add(List.of("a", "0549"));
        accessTimes.add(List.of("b", "0457"));
        accessTimes.add(List.of("a", "0532"));
        accessTimes.add(List.of("a", "0621"));
        accessTimes.add(List.of("b", "0540"));
        List<String> ans = find(accessTimes);
        for (String r : ans) {
            System.out.println(r);
        }
    }
}

// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.Collections;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// public class EmployeePrioritySystem {

// public static List<String> findEmployee(List<List<String>> accessTimes) {
// Map<String, List<Integer>> map = new HashMap<>();
// for (List<String> access : accessTimes) {
// map.computeIfAbsent(access.get(0), v -> new
// ArrayList<>()).add(Integer.valueOf(access.get(1)));

// }
// List<String> result = new ArrayList<>();
// for (String employee : map.keySet()) {
// if (map.get(employee).size() < 2) {
// continue;
// }
// Collections.sort(map.get(employee));
// for (int i = 0; i < map.get(employee).size() - 2; i++) {
// if (map.get(employee).get(i) + 100 > map.get(employee).get(i + 1)
// && map.get(employee).get(i) + 100 > map.get(i + 2)) {
// result.add(employee);
// break;
// }
// }
// }
// return result;
// }

// public static void main(String[] args) {
// List<List<String>> accessTimes = new ArrayList<>();
// accessTimes.add(List.of("a", "0549"));
// accessTimes.add(List.of("b", "0457"));
// accessTimes.add(List.of("a", "0532"));
// accessTimes.add(List.of("a", "0621"));
// accessTimes.add(List.of("b", "0540"));

// List<String> result = findEmployee(accessTimes);
// }
// }
