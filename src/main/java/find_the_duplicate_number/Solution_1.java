package find_the_duplicate_number;

public class Solution_1 implements Solution {

    @Override
    public int findDuplicate(int[] nums) {
        // list 0 1 2 3 4
        // pointer 1 -> 2 -> 3 -> 4 -> 3
        if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}
