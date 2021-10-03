package combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1 implements Solution {

    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resList = new ArrayList<>();
        combinationSumImpl(resList, new ArrayList<>(), candidates, target, 0);
        return resList;
    }

    private void combinationSumImpl(List<List<Integer>> resList, List<Integer> tmpList, int[] candidates, int remain, int start) {
        if (remain == 0) {
            resList.add(new ArrayList<>(tmpList));
        } else if (remain > 0) {
            for (int i = start; i < candidates.length; i++) {
                tmpList.add(candidates[i]);
                combinationSumImpl(resList, tmpList, candidates, remain - candidates[i], i);
                tmpList.remove(tmpList.size() - 1); // O(1)
            }
        }
    }
}
