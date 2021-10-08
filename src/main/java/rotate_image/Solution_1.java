package rotate_image;

public class Solution_1 implements Solution {

    @Override
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        // a transpose equals a horizontal flip and 90 degree rotate clockwise
        // we first manually do a horizontal flip and a transpose
        // so two flip equals identity, the result is a 90 degree clockwise rotate

        // note: a transpose can also equal a vertical flip and 90 degree rotate anti-clockwise
        // so manually a vertical flip followed by a transpose equals a 90 degree anti-clockwise rotate
        for (int i = 0, j = matrix.length - 1; i < j; i++, j--) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = tmp;
        }
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
