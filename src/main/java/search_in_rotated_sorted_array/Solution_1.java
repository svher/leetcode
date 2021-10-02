package search_in_rotated_sorted_array;

public class Solution_1 implements Solution {

    @Override
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // Either mid is in left portion of array
                // Or mid in in the right but target in smaller than rightmost value
                if (nums[l] <= nums[mid] || target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (nums[mid] <= nums[r] || target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
