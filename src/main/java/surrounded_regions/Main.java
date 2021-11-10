package surrounded_regions;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        char[][] board = new char[][] {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));

        board = new char[][] {{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
