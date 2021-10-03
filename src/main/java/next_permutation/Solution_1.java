package next_permutation;

public class Solution_1 implements Solution {

    void reverse(int[] array, int start, int end) {
        int tmp;
        while (end > start) {
            tmp = array[end];
            array[end] = array[start];
            array[start] = tmp;
            end--;
            start++;
        }
    }

    @Override
    public void nextPermutation(int[] nums) {
        int k = nums.length - 2;
        for (; k >= 0; --k) {
            // Step 1: 找到第一个切入点，后面全逆序，设为 k
            if (nums[k] < nums[k + 1]) {
                break;
            }
        }
        if (k < 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int j = nums.length - 1;
            for (; j > k; --j) {
                if (nums[j] > nums[k]) { // 1 3 4 2
                    break;
                }
            }
            // Step 2: 把 k 和后面最小的比它大的数对调，由于 k 后面全逆序，所以满足条件比 k 大的最小数一定在最后，设为 j
            int tmp = nums[k];
            nums[k] = nums[j];
            nums[j] = tmp;
            // Step 3: 调换后 k 后面仍为逆序，将其整体翻转即可
            reverse(nums, j + 1, nums.length - 1); // 3 4 5 2 1
        }
    }
}
