package larget_rectangle_in_histogram;

import java.util.Stack;

public class Solution_1 implements Solution {

    @Override
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i <= heights.length; i++) {
            while (stack.peek() != -1 && (i == heights.length || heights[stack.peek()] >= heights[i])) {
                int prev = stack.pop();
                int area = (i - stack.peek() - 1)  * heights[prev];
                ans = Math.max(area, ans);
            }
            stack.add(i);
        }
        return ans;
    }
}
