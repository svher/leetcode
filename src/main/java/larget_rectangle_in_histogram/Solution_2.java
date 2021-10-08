package larget_rectangle_in_histogram;

public class Solution_2 implements Solution {

    @Override
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] lessFromLeft = new int[n], lessFromRight = new int[n];

        // each link will only use once
        // 假设一个链接被使用两次，也就是说有链接的元素右侧有两个元素比链接的元素小
        // 假设两个元素为 a 和 b， 如果 a < b, 那么 b 会直接链接到 a，不会用到这个链接
        // 如果 a >= b，那么 b 会使用 a 的链接而不是使用这个链接
        lessFromLeft[0] = -1;
        for (int i = 1; i < n; i++) {
            int p = i - 1;
            while (p != -1 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        lessFromRight[n - 1] = n;
        for (int i = n - 1; i >= 0; i--) {
            int p = i + 1;
            while (p != heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int area = (lessFromRight[i] - lessFromLeft[i] - 1) * heights[i];
            ans = Math.max(area, ans);
        }
        return ans;
    }
}
