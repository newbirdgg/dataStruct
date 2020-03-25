package data.math;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第892题——三维形体的表面积
 * @Date: 2020/3/25 7:17
 * @Email: 1031759184@qq.com
 */
public class Solution8 {
    private int rows, cols, area;

    public int surfaceArea(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int pos = grid[i][j];
                if (pos != 0) {
                    area += (pos << 2) + 2;
                    if (i  > 0) {
                        area -= Math.min(grid[i - 1][j], pos) << 1;
                    }
                    if (j > 0) {
                        area -= Math.min(grid[i][j - 1], pos) << 1;
                    }
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        Solution8 solution8 = new Solution8();
        solution8.surfaceArea(a);
    }
}
