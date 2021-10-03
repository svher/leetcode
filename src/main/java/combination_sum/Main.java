package combination_sum;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_2();
        List<List<Integer>> res = solution.combinationSum(new int[] {2, 3, 6, 7}, 7);
        System.out.println(res.toString());
    }
}
