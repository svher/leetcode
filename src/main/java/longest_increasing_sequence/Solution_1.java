package longest_increasing_sequence;

public class Solution_1 implements Solution {

    @Override
    public int lengthOfLIS(int[] nums) {
        int[] seq = new int[nums.length];
        int k = 0;
        for (int num : nums) {
            if (k == 0 || num > seq[k - 1]) {
                seq[k++] = num;
            } else {
                for (int i = 0; i < k; i++) {
                    if (num <= seq[i]) {
                        seq[i] = num;
                        break;
                    }
                }
            }
        }
        return k;
    }
}
