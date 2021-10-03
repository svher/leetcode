package rotate_array;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
