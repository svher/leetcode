package the_skyline_problem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution_2();
        List<List<Integer>> ans =  solution.getSkyline(new int[][] {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});
        System.out.println(ans);
        ans = solution.getSkyline(new int[][] {{0, 2, 3}, {2, 5, 3}});
        System.out.println(ans);
    }
}
