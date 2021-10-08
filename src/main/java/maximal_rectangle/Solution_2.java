package maximal_rectangle;

import java.util.Arrays;

public class Solution_2 implements Solution {

    @Override
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] leftBoundary = new int[n], rightBoundary = new int[n], height = new int[n];
        int ans = 0;
        Arrays.fill(leftBoundary, -1);
        Arrays.fill(rightBoundary, n);
        for (int i = 0; i < m; i++) {
            int left = -1;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    leftBoundary[j] = Math.max(leftBoundary[j], left);
                } else {
                    leftBoundary[j] = -1;
                    left = j;
                }
            }

            int right = n;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    rightBoundary[j] = Math.min(rightBoundary[j], right);
                } else {
                    rightBoundary[j] = m;
                    right = j;
                }
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                    int area = (rightBoundary[j] - leftBoundary[j] - 1) * height[j];
                    ans = Math.max(area, ans);
                } else {
                    height[j] = 0;
                }
            }
        }
        return ans;
    }
}
