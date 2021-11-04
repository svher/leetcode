package others.heap;

import java.util.Arrays;

public class BuildingHeap {

    private static void heapify(int[] nums, int i) {
        if (i > nums.length / 2 - 1) {
            return;
        }

        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < nums.length && nums[l] > nums[i]) {
            largest = l;
        }

        if (r < nums.length && nums[r] > nums[largest]) {
            largest = r;
        }

        if (largest != i) {
            int tmp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = tmp;
            heapify(nums, largest);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, i);
        }
        System.out.println(Arrays.toString(nums));
    }
}
