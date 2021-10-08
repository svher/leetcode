package sort_colors;

public class Solution_1 implements Solution {

    @Override
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1;
        for (int i = 0; i <= end; i++) {
            while (nums[i] == 2 && i < end) {
                nums[i] = nums[end];
                nums[end--] = 2;
            }
            while (nums[i] == 0 && i > start) {
                nums[i] = nums[start];
                nums[start++] = 0;
            }
        }
    }
}
