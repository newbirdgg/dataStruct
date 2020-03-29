package data.bfs;

import java.util.LinkedList;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第695题-岛屿最大面积(广度优先解法)
 * @Date: 2020/3/15 7:07
 * @Email: 1031759184@qq.com
 */
public class Solution1 {
    private int rows, cols, maxArea, area;
    private boolean[][] isMark;
    private int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private LinkedList<Integer> queue = new LinkedList<>();

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        isMark = new boolean[rows][cols];
        if (rows == 0 || cols == 0) {
            return 0;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!isMark[i][j] && grid[i][j] == 1) {
                    queue.addLast(i * cols + j);
                    isMark[i][j] = true;
                    while (!queue.isEmpty()) {
                        int cur = queue.removeFirst();
                        area++;
                        int curRow = cur / cols;
                        int curCol = cur % cols;
                        for (int k = 0; k < 4; k++) {
                            int newRow = curRow+direct[k][0];
                            int newCol = curCol+direct[k][1];
                            if (isInArea(newRow,newCol)&&!isMark[newRow][newCol]&&grid[newRow][newCol]==1){
                                queue.addLast(newRow*cols+newCol);
                                isMark[newRow][newCol] = true;

                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                    area = 0;
                }
            }
        }
        return maxArea;
    }


    private boolean isInArea(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public static void main(String[] args) {
        int[][] a = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        Solution1 solution = new Solution1();
        System.out.println(solution.maxAreaOfIsland(a));
    }
}
