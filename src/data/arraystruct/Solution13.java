package data.arraystruct;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第289题——生命游戏
 * @Date: 2020/4/2 7:23
 * @Email: 1031759184@qq.com
 */
public class Solution13 {
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private boolean[][] isChange;
    private int rows, cols;

    public void gameOfLife(int[][] board) {
        rows = board.length;
        cols = board[0].length;
        if (rows == 0 || cols == 0) {
            return;
        }
        isChange = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int live = 0;
                for (int k = 0; k < 8; k++) {
                    int newRow = i + direction[k][0];
                    int newCol = j + direction[k][1];
                    boolean isCurAlive = (inArea(newRow, newCol) && !isChange[newRow][newCol] && board[newRow][newCol] == 1)||(inArea(newRow, newCol) && isChange[newRow][newCol] && (board[newRow][newCol] ^ 1) == 1);
                    if(isCurAlive) ++live;
                }
                if (board[i][j] == 1 && live < 2 || (board[i][j] == 1 && live > 3)) {
                    board[i][j] = 0;
                    isChange[i][j] = true;
                } else if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 1;
                    isChange[i][j] = true;
                }

            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }

    public static void main(String[] args) {
        int[][] pos = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0},
        };
        Solution13 s = new Solution13();
        s.gameOfLife(pos);
        System.out.println(Arrays.deepToString(pos));
    }
}
