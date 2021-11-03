package four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1 implements Solution {

    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int l = j + 1, r = nums.length - 1;
                int twoTarget = target - nums[i] - nums[j];
                while (l < r) {
                    if (nums[l] + nums[r] > twoTarget) {
                        r--;
                    } else if (nums[l] + nums[r] < twoTarget) {
                        l++;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[++l]);
                        while (l < r && nums[r] == nums[--r]);
                    }
                }
            }
        }
        return ans;
    }
}
