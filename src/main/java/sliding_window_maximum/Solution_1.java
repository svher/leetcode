package sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1 implements Solution {

    @Override
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1) {
            return null;
        }
        if (k == 1) {
            return nums;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                assert(!deque.isEmpty());
                res[j++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
