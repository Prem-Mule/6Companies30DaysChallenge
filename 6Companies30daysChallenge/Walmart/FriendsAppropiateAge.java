package Walmart;

public class FriendsAppropiateAge {
    static public int numFriendRequests(int[] ages) {
        int map[] = new int[121];
        for (int j = 0; j < ages.length; j++) {
            map[ages[j]]++;
        }

        for (int i = 1; i <= 120; i++) {
            map[i] += map[i - 1];
        }
        int totalFriend = 0;
        for (int i = 0; i < ages.length; i++) {
            int cond = ages[i] / 2 + 7;
            if (cond >= ages[i]) {
                continue;
            }
            totalFriend += map[ages[i]] - map[cond] - 1;
        }
        return totalFriend;
    }

    public static void main(String[] args) {
        int[] ages = { 6, 16 };
        System.out.println(numFriendRequests(ages));
    }
}
/*
 * There are n persons on a social media website. You are given an integer array
 * ages where ages[i] is the age of the ith person.
 * 
 * A Person x will not send a friend request to a person y (x != y) if any of
 * the following conditions is true:
 * 
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 * Otherwise, x will send a friend request to y.
 * 
 * Note that if x sends a request to y, y will not necessarily send a request to
 * x. Also, a person will not send a friend request to themself.
 * 
 * Return the total number of friend requests made.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ages = [16,16]
 * Output: 2
 * Explanation: 2 people friend request each other.
 * Example 2:
 * 
 * Input: ages = [16,17,18]
 * Output: 2
 * Explanation: Friend requests are made 17 -> 16, 18 -> 17.
 * Example 3:
 * 
 * Input: ages = [20,30,100,110,120]
 * Output: 3
 * Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
 */