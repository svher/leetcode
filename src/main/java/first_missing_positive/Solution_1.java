package first_missing_positive;

public class Solution_1 implements Solution {

    @Override
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] != i) {
                return i;
            }
        }
        return n + 1;
    }
}
