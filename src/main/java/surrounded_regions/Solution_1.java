package surrounded_regions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1 implements Solution {

    private static final int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    @Override
    public void solve(char[][] board) {
        if (board.length <= 2 || board[0].length <= 2) {
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                bfs(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                bfs(board, board.length - 1, i);
            }
        }
        for (int i = 1; i < board.length - 1; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                bfs(board, i, board[0].length - 1);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(char[][] board, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        board[x][y] = '1';
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            x = top[0];
            y = top[1];
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] == 'O') {
                    queue.add(new int[] {newX, newY});
                    board[newX][newY] = '1';
                }
            }
        }
    }
}
