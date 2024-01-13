import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You are given an integer matrix isWater of size m x n that represents a map
 * of land and water cells.
 * 
 * If isWater[i][j] == 0, cell (i, j) is a land cell.
 * If isWater[i][j] == 1, cell (i, j) is a water cell.
 * You must assign each cell a height in a way that follows these rules:
 * 
 * The height of each cell must be non-negative.
 * If the cell is a water cell, its height must be 0.
 * Any two adjacent cells must have an absolute height difference of at most 1.
 * A cell is adjacent to another cell if the former is directly north, east,
 * south, or west of the latter (i.e., their sides are touching).
 * Find an assignment of heights such that the maximum height in the matrix is
 * maximized.
 * 
 * Return an integer matrix height of size m x n where height[i][j] is cell (i,
 * j)'s height. If there are multiple solutions, return any of them.
 * 
 * Example 1:
 *
 * Input: isWater = [[0,1],[0,0]]
 * Output: [[1,0],[2,1]]
 * Explanation: The image shows the assigned heights of each cell.
 * The blue cell is the water cell, and the green cells are the land cells.
 * Example 2:
 * 
 * Input: isWater = [[0,0,1],[1,0,0],[0,0,0]]
 * Output: [[1,1,0],[0,1,1],[1,2,2]]
 * Explanation: A height of 2 is the maximum possible height of any assignment.
 * Any height assignment that has a maximum height of 2 while still meeting the
 * rules will also be accepted.
 */
public class MapOfHighestPeak {
    public static int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new int[] { i, j });
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int i = current[0];
            int j = current[1];

            int[] dx = { -1, 0, 1, 0 };
            int[] dy = { 0, 1, 0, -1 };

            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];

                if (x >= 0 && x < m && y >= 0 && y < n && ans[x][y] == -1) {
                    ans[x][y] = ans[i][j] + 1;
                    q.add(new int[] { x, y });
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] isWater = { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 0, 0 } };
        int[][] heights = highestPeak(isWater);
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights.length; j++) {
                System.out.print(heights[i][j] + " ");
            }
            System.out.println();
        }
    }
}