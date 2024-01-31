package Adobe;

public class MinRoadCostWithSpecificPath {
    public static void main(String[] args) {

    }
}
/*
 * You are given an array start where start = [startX, startY] represents your
 * initial position (startX, startY) in a 2D space. You are also given the array
 * target where target = [targetX, targetY] represents your target position
 * (targetX, targetY).
 * 
 * The cost of going from a position (x1, y1) to any other position in the space
 * (x2, y2) is |x2 - x1| + |y2 - y1|.
 * 
 * There are also some special roads. You are given a 2D array specialRoads
 * where specialRoads[i] = [x1i, y1i, x2i, y2i, costi] indicates that the ith
 * special road can take you from (x1i, y1i) to (x2i, y2i) with a cost equal to
 * costi. You can use each special road any number of times.
 * 
 * Return the minimum cost required to go from (startX, startY) to (targetX,
 * targetY).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: start = [1,1], target = [4,5], specialRoads =
 * [[1,2,3,3,2],[3,4,4,5,1]]
 * Output: 5
 * Explanation: The optimal path from (1,1) to (4,5) is the following:
 * - (1,1) -> (1,2). This move has a cost of |1 - 1| + |2 - 1| = 1.
 * - (1,2) -> (3,3). This move uses the first special edge, the cost is 2.
 * - (3,3) -> (3,4). This move has a cost of |3 - 3| + |4 - 3| = 1.
 * - (3,4) -> (4,5). This move uses the second special edge, the cost is 1.
 * So the total cost is 1 + 2 + 1 + 1 = 5.
 * It can be shown that we cannot achieve a smaller total cost than 5.
 */