package data.bfs;

import java.util.LinkedList;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第1162题——地图分析
 * @Date: 2020/3/29 7:11
 * @Email: 1031759184@qq.com
 */
public class Solution2 {
    private int rows, cols, result;
    private LinkedList<Integer> queue;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxDistance(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    queue.addLast(i * cols + j);
                }
            }
        }
        if (queue.isEmpty() || queue.size() == rows * cols) {
            return -1;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                int cur = queue.pop();
                int curRow = cur / cols;
                int curCol = cur % cols;
                for (int k = 0; k < 4; k++) {
                    int newRow = curRow + direction[k][0];
                    int newCol = curCol + direction[k][1];
                    if (inArea(newRow, newCol) && grid[newRow][newCol] == 0) {
                        grid[newRow][newCol] = 1;
                        queue.addLast(newRow * cols + newCol);
                    }
                }
            }
        }
        return --result;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }

    public static void main(String[] args) {
        //[[0,0,1,1,1],[0,1,1,0,0],[0,0,1,1,0],[1,0,0,0,0],[1,1,0,0,1]]
        int[][] grid = {
                {0, 0, 1, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 1}
        };
        Solution2 s = new Solution2();
        System.out.println(s.maxDistance(grid));
    }
}
