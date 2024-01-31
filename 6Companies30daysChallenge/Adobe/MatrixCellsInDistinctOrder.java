package Adobe;

public class MatrixCellsInDistinctOrder {
    static public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][];
        result[0] = new int[] { r0, c0 }; // Add start point r0,c0 which has distance 0.
        int resultIdx = 1;
        int lim = Math.max(r0, R - r0 - 1) + Math.max(c0, C - c0 - 1);
        // lim is highest distance value.
        for (int dist = 1; dist <= lim; dist++) { // Process 'lim' diamond-shapes having distance 'dist'.
            int r = r0 - dist;
            int c = c0;
            // Diamond side: Top Left
            for (int count = dist; count > 0; count--) {
                if (r >= 0 && c >= 0)
                    result[resultIdx++] = new int[] { r, c };
                r++;
                c--;
            }

            // Diamond side: Left Bottom
            for (int count = dist; count > 0; count--) {
                if (r < R && c >= 0)
                    result[resultIdx++] = new int[] { r, c };
                r++;
                c++;
            }

            // Diamond side: Bottom Right
            for (int count = dist; count > 0; count--) {
                if (r < R && c < C)
                    result[resultIdx++] = new int[] { r, c };
                r--;
                c++;
            }

            // Diamond side: Right Top
            for (int count = dist; count > 0; count--) {
                if (r >= 0 && c < C)
                    result[resultIdx++] = new int[] { r, c };
                r--;
                c--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = allCellsDistOrder(1, 2, 0, 0);
        System.out.println();
    }
}
/*
 * You are given four integers row, cols, rCenter, and cCenter. There is a rows
 * x cols matrix and you are on the cell with the coordinates (rCenter,
 * cCenter).
 * 
 * Return the coordinates of all cells in the matrix, sorted by their distance
 * from (rCenter, cCenter) from the smallest distance to the largest distance.
 * You may return the answer in any order that satisfies this condition.
 * 
 * The distance between two cells (r1, c1) and (r2, c2) is |r1 - r2| + |c1 -
 * c2|.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: rows = 1, cols = 2, rCenter = 0, cCenter = 0
 * Output: [[0,0],[0,1]]
 * Explanation: The distances from (0, 0) to other cells are: [0,1]
 */