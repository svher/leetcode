package longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

class Solution_1 implements Solution {

    @Override
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                int l = num, r = num;
                while (set.remove(--l));
                while (set.remove(++r));
                ans = Math.max(r - l - 1, ans);
            }
        }
        return ans;
    }
}