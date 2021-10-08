package jump_game_ii;

public class Solution_1 implements Solution {

    @Override
    public int jump(int[] nums) {
        int jumps = 0, farthest = 0, end = 0;
        for (int i = 0; i <= end; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (end >= nums.length - 1) {
                return jumps;
            }
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }
        return -1;
    }
}
