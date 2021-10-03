package combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_2 implements Solution {

    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            List<List<Integer>> resList = new ArrayList<>();
            for (int candidate : candidates) {
                if (i == candidate) {
                    resList.add(Collections.singletonList(i));
                } else if (candidate < i){
                    for (List<Integer> prevList : dp.get(i - candidate - 1)) {
                        if (candidate >= prevList.get(prevList.size() - 1)) {
                            List<Integer> tmpList = new ArrayList<>(prevList);
                            tmpList.add(candidate);
                            resList.add(tmpList);
                        }
                    }
                } else {
                    break;
                }
            }
            dp.add(resList);
        }
        return dp.get(dp.size() - 1);
    }
}
