package merge_intervals;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int[][] res = solution.merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println(Arrays.deepToString(res));
    }
}
