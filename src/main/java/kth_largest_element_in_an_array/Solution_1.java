package kth_largest_element_in_an_array;

import java.util.Random;

public class Solution_1 implements Solution {

    private final Random random = new Random();

    @Override
    public int findKthLargest(int[] nums, int k) {
        k--;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int pivotIdx = partition(nums, l, r);
            if (pivotIdx < k) {
                l = pivotIdx + 1;
            } else if (pivotIdx > k) {
                r = pivotIdx - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int start, int end) {
        // Note: It's not possible to use Hoare’s algorithm here,
        // because the pivot final location is not necessarily at the index was returned
        int rand = random.nextInt(end - start + 1) + start;
        swap(nums, start, rand);
        int l = start, r = end;
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] <= pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] >= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
