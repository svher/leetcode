package find_first_and_last_position_of_element_in_sorted_array;

public class Solution_1 implements Solution {

    @Override
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] {-1, -1};
        if (nums.length == 0) {
            return ans;
        }
        // 这里查找第一个大于或第一个小于的时候，需要以 l 或者 r 作为结果，因为 l 或者 r 对应的左(右)区间都是不符合要求的
        int l = 0, r = nums.length - 1, mid = 0;
        while (l < r) {
            mid = (l + r) >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums[l] != target) {
            return ans;
        } else {
            ans[0] = l;
        }
        l = mid;
        r = nums.length - 1;
        while (l < r) {
            mid = (l + r + 1) >> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        ans[1] = r;
        return ans;
    }
}
