package data.arraystruct;

import java.util.Arrays;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第999题——车的可用捕获量
 * @Date: 2020/3/26 7:13
 * @Email: 1031759184@qq.com
 */
public class Solution10 {
    private int rows, cols, count, pos, prePos;
    private boolean[] direction;

    public int numRookCaptures(char[][] board) {
        //0.上 1.下 2.左 3.右
        direction = new boolean[4];
        direction[0] = true;
        rows = board.length;
        cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'R') {
                    prePos = i * cols + j;
                    catchPawn(prePos, board);
                    break;
                }
            }
        }
        return count;
    }

    private void catchPawn(int index, char[][] board) {
        int curRow = index / cols;
        int curCol = index % cols;
        if (inArea(curRow, curCol) && board[curRow][curCol] == 'p') {
            count++;
            return;
        }
        if (!inArea(curRow, curCol) || board[curRow][curCol] == 'B') {
            return;
        }
        if (direction[0] && curRow > 0) {
            //往上走
            catchPawn((curRow - 1) * cols + curCol, board);
            if (curRow == prePos / cols && curCol == prePos % cols) {
                direction[pos] = false;
                direction[++pos] = true;
            }
        }
        if (direction[1] && curRow < rows && curCol == prePos % cols) {
            catchPawn((curRow + 1) * cols + curCol, board);
            if (curRow == prePos / cols && curCol == prePos % cols) {
                direction[pos] = false;
                direction[++pos] = true;
            }
        }
        if (direction[2] && curCol > 0) {
            catchPawn(curRow * cols + curCol - 1, board);
            if (curRow == prePos / cols && curCol == prePos % cols) {
                direction[pos] = false;
                direction[++pos] = true;
            }
        }
        if (direction[3] && curCol < cols && curRow == prePos / cols) {
            catchPawn(curRow * cols + curCol + 1, board);
        }
    }

    private boolean inArea(int a, int b) {
        return a >= 0 && b >= 0 && a < rows && b < cols;
    }

    public static void main(String[] args) {
        char[][] a = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
        };
        Solution10 s = new Solution10();
        System.out.println(s.numRookCaptures(a));
    }
}
