import java.util.Random;
import java.util.TreeMap;

public class RandomPntInNonOverlappingRect {
    static int[][] rects;
    static TreeMap<Integer, Integer> weightedRectIndex = new TreeMap<>();
    static int nPoints = 0;

    static Random rng = new Random();

    public RandomPntInNonOverlappingRect(int[][] rects) {
        this.rects = rects;
        int index = 0;
        for (int[] rect : rects) {
            // inserts cumulative weight key pointing to rectangle index
            weightedRectIndex.put(nPoints, index++);
            nPoints += width(rect) * height(rect);
        }
    }

    static public int[] pick() {
        // generates random point within total weight
        int point = rng.nextInt(nPoints);
        // finds appropriate rectangle
        var entry = weightedRectIndex.floorEntry(point);
        // find point within the current rectangle
        int rectPoint = point - entry.getKey();
        int[] rect = rects[entry.getValue()];
        return new int[] {
                rect[0] + rectPoint % width(rect),
                rect[1] + rectPoint / width(rect) };
    }

    static private int width(int[] rect) {
        return rect[2] - rect[0] + 1;
    }

    static private int height(int[] rect) {
        return rect[3] - rect[1] + 1;
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(rects);
     * int[] param_1 = obj.pick();
     */
    public static void main(String[] args) {

    }
}
/*
 * You are given an array of non-overlapping axis-aligned rectangles rects where
 * rects[i] = [ai, bi, xi, yi] indicates that (ai, bi) is the bottom-left corner
 * point of the ith rectangle and (xi, yi) is the top-right corner point of the
 * ith rectangle. Design an algorithm to pick a random integer point inside the
 * space covered by one of the given rectangles. A point on the perimeter of a
 * rectangle is included in the space covered by the rectangle.
 * 
 * Any integer point inside the space covered by one of the given rectangles
 * should be equally likely to be returned.
 * 
 * Note that an integer point is a point that has integer coordinates.
 * 
 * Implement the Solution class:
 * 
 * Solution(int[][] rects) Initializes the object with the given rectangles
 * rects.
 * int[] pick() Returns a random integer point [u, v] inside the space covered
 * by one of the given rectangles.
 */