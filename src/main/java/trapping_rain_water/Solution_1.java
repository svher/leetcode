package trapping_rain_water;

import java.util.Stack;

public class Solution_1 implements Solution {

    @Override
    public int trap(int[] heights) {
        // 4, 2, 0, 3, 2, 5
        Stack<Integer> stack = new Stack<>();
        int waterVol = 0;
        for (int i = 0; i < heights.length; ++i) {
            int height = heights[i];
            while (!stack.empty() && heights[stack.peek()] <= height) {
                int prev = stack.pop();
                if (!stack.isEmpty()) {
                    waterVol += (Math.min(height, heights[stack.peek()]) - heights[prev]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }

        return waterVol;
    }
}
