package data.dynamicprogramming;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第695题-岛屿最大面积(深度优先解法)
 * @Date: 2020/3/15 7:07
 * @Email: 1031759184@qq.com
 */
public class Solution4 {
    private int rows, cols, maxArea, area;
    private boolean[][] isMark;
    private int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        isMark = new boolean[rows][cols];
        if (rows == 0 || cols == 0) {
            return 0;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(grid, i, j);
                maxArea = Math.max(maxArea, area);
                area = 0;
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int row, int col) {
        if (isInArea(row, col) && !isMark[row][col] && grid[row][col] == 1) {
            isMark[row][col] = true;
            for (int k = 0; k < 4; k++) {
                int newRow = row + direct[k][0];
                int newCol = col + direct[k][1];
                dfs(grid, newRow, newCol);
            }
            area++;
        }
    }

    private boolean isInArea(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public static void main(String[] args) {
        int[][] a= {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        Solution4 solution = new Solution4();
        System.out.println(solution.maxAreaOfIsland(a));
    }
}
