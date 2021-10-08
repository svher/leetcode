package maximal_square;

import java.util.Arrays;

public class Solution_1 implements Solution {

    @Override
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] cur = new int[n + 1], prev = new int[n + 1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            System.arraycopy(cur, 0, prev, 0, n + 1);
            Arrays.fill(cur, 0);
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    cur[j] = Math.min(prev[j], Math.min(prev[j - 1], cur[j - 1])) + 1;
                    res = Math.max(cur[j], res);
                }
            }
        }
        return res * res;
    }
}
