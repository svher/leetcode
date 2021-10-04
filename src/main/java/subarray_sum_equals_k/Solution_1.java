package subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

public class Solution_1 implements Solution {

    @Override
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> preSum = new HashMap<>();

        preSum.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (preSum.containsKey(sum - k)) {
                res += preSum.get(sum - k);
            }
            preSum.compute(sum, (key, value) -> value == null ? 1 : value + 1);
        }
        return res;
    }
}
