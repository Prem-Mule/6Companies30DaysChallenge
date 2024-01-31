package Adobe;

import java.util.ArrayList;
import java.util.List;

public class SkylineProblem {
    static class TopNode {
        int x;
        int h;
        TopNode next;

        TopNode() {
        }

        TopNode(int x, int h) {
            this.x = x;
            this.h = h;
        }

        void insert(TopNode n) {
            n.next = next;
            next = n;
        }

    }

    static final int LEFT = 0, RIGHT = 1, HEIGHT = 2;

    static public List<List<Integer>> getSkyline(int[][] buildings) {
        TopNode head = new TopNode(0, 0);
        head.insert(new TopNode(Integer.MAX_VALUE, 0));
        TopNode start = head;

        for (int i = 0; i < buildings.length; i++) {
            int[] b = buildings[i];
            int bL = buildings[i][LEFT];
            int bR = buildings[i][RIGHT];
            int bH = buildings[i][HEIGHT];
            // System.out.println(Arrays.toString(buildings[i]));
            while (bL >= start.next.x) {
                start = start.next;
            }
            // System.out.println(start.toString());
            for (TopNode t = start; bR > t.x; t = t.next) {
                // System.out.println(head.toString());
                if (bH <= t.h) {
                    continue;
                }

                TopNode stop = t;
                while (stop.next != null && stop.next.x < bR && stop.next.h <= bH) {
                    stop = stop.next;
                }

                if (bL <= t.x) {
                    if (bR >= stop.next.x) {
                        t.next = stop.next;
                        t.h = bH;
                    } else if (t == stop) {
                        t.insert(new TopNode(bR, t.h));
                        t.h = bH;
                        break;
                    } else {
                        stop.x = bR;
                        t.h = bH;
                        t.next = stop;
                        break;
                    }
                } else {
                    if (bR >= stop.next.x) {
                        if (t == stop) {
                            t.insert(new TopNode(bL, bH));
                        } else {
                            t.next = stop;
                            stop.x = bL;
                            stop.h = bH;
                        }
                        break;
                    } else if (t == stop) {
                        t.insert(new TopNode(bL, bH));
                        t.next.insert(new TopNode(bR, t.h));
                        break;
                    } else {
                        t.next = stop;
                        t.insert(new TopNode(bL, bH));
                        stop.x = bR;
                        break;
                    }
                }
                t = stop;

            }
        }

        List<List<Integer>> skyline = new ArrayList<>();

        if (head.h == 0)
            head = head.next;
        while (head != null) {
            int height = head.h;
            skyline.add(List.of(head.x, height));
            while ((head = head.next) != null && head.h == height) {
            }
        }

        return skyline;
    }

    public static void main(String[] args) {

    }
}
/*
 * 
 * A city's skyline is the outer contour of the silhouette formed by all the
 * buildings in that city when viewed from a distance. Given the locations and
 * heights of all the buildings, return the skyline formed by these buildings
 * collectively.
 * 
 * The geometric information of each building is given in the array buildings
 * where buildings[i] = [lefti, righti, heighti]:
 * 
 * lefti is the x coordinate of the left edge of the ith building.
 * righti is the x coordinate of the right edge of the ith building.
 * heighti is the height of the ith building.
 * You may assume all buildings are perfect rectangles grounded on an absolutely
 * flat surface at height 0.
 * 
 * The skyline should be represented as a list of "key points" sorted by their
 * x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left
 * endpoint of some horizontal segment in the skyline except the last point in
 * the list, which always has a y-coordinate 0 and is used to mark the skyline's
 * termination where the rightmost building ends. Any ground between the
 * leftmost and rightmost buildings should be part of the skyline's contour.
 * 
 * Note: There must be no consecutive horizontal lines of equal height in the
 * output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is
 * not acceptable; the three lines of height 5 should be merged into one in the
 * final output as such: [...,[2 3],[4 5],[12 7],...]
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * Explanation:
 * Figure A shows the buildings of the input.
 * Figure B shows the skyline formed by those buildings. The red points in
 * figure B represent the key points in the output list.
 * Example 2:
 * 
 * Input: buildings = [[0,2,3],[2,5,3]]
 * Output: [[0,3],[5,0]]
 * 
 */