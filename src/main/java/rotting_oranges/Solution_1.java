package rotting_oranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1 implements Solution {

    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    @Override
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int cnt_fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    cnt_fresh++;
                }
            }
        }
        int time_elapsed = 0;
        while (!queue.isEmpty() && cnt_fresh > 0) {
            int sz_queue = queue.size();
            for (int i = 0; i < sz_queue && cnt_fresh > 0; i++) {
                int[] top = queue.poll();
                for (int[] dir : directions) {
                    assert top != null;
                    int new_i = top[0] + dir[0];
                    int new_j = top[1] + dir[1];
                    if (new_i < 0 || new_i >= m || new_j < 0 || new_j >= n) {
                        continue;
                    }
                    if (grid[new_i][new_j] == 1) {
                        grid[new_i][new_j] = 2;
                        queue.add(new int[] {new_i, new_j});
                        cnt_fresh--;
                    }
                }
            }
            time_elapsed++;
        }
        return cnt_fresh > 0 ? -1 : time_elapsed;
    }
}
