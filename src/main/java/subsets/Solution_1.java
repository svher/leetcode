package subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 implements Solution {

    @Override
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsetsImpl(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void subsetsImpl(int[] nums, int start, List<Integer> tmpList, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(tmpList));
        for (int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            subsetsImpl(nums, i + 1, tmpList, ans);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
