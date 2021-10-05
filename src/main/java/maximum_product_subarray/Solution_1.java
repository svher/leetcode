package maximum_product_subarray;

public class Solution_1 implements Solution {

    @Override
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = res, max = res;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            min = Math.min(num, num * min);
            max  = Math.max(num, num * max);
            res = Math.max(max, res);
        }
        return res;
    }
}
