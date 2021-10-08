package maximal_rectangle;

import java.util.Stack;

public class Solution_1 implements Solution {

    @Override
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n + 1];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleInHistogram(heights));
        }
        return ans;
    }

    private int largestRectangleInHistogram(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            while (stack.peek() != -1 && nums[stack.peek()] >= nums[i]) {
                int prev = stack.pop();
                int area = nums[prev] * (i - stack.peek() - 1);
                ans = Math.max(ans, area);
            }
            stack.add(i);
        }
        return ans;
    }
}