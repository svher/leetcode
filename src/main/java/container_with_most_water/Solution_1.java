package container_with_most_water;

public class Solution_1 implements Solution {

    @Override
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int ans = 0;
        while (start < end) {
            ans = Math.max(Math.min(height[start], height[end]) * (end - start), ans);
            // 优先步进最矮的即可
            if (height[start] < height[end]) {
                ++start;
            } else {
                --end;
            }
        }
        return ans;
    }
}
