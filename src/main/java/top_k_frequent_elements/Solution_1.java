package top_k_frequent_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_1 implements Solution {

    @Override
    @SuppressWarnings("unchecked")
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.compute(num, (key, freq) -> freq == null ? 1 : freq + 1);
        }
        List<Integer>[] buckets = new List[nums.length];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && k > 0; i--) {
            if (buckets[i] != null) {
                res.addAll(buckets[i]);
                k -= buckets[i].size();
            }
        }
        return res.stream().mapToInt(value -> value).toArray();
    }
}
