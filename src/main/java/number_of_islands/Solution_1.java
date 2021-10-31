package number_of_islands;

public class Solution_1 implements Solution {

    static final int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    @Override
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '#';
        for (int[] direction : directions) {
            dfs(grid, i + direction[0], j + direction[1]);
        }
    }
}
