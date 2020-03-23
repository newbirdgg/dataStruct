package data.queuestruct;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第5366题——检查网格中是否存在有效路径
 * @Date: 2020/3/22 14:30
 * @Email: 1031759184@qq.com
 */
public class Solution2 {
    private int rows, cols;
    private LinkedList<Integer> queue;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] isMarked;

    public boolean hasValidPath(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        isMarked = new boolean[rows][cols];
        if (rows == 1 && cols == 1) {
            return true;
        }
        if (grid[0][0] == 5) {
            return false;
        }
        int row = 0, col = 0;
        queue = new LinkedList<>();
        queue.push(row * cols + col);
        isMarked[row][col] = true;
        while (!queue.isEmpty()) {
            int cur = queue.pop();
            int curRow = cur / cols;
            int curCol = cur % cols;
            if (curRow == rows-1&&curCol == cols-1){
                return true;
            }
            int roadType = grid[curRow][curCol];
            if (roadType == 1) {
                selectRoad(0, curRow, curCol, grid, roadType);
                selectRoad(1, curRow, curCol, grid, roadType);
            } else if (roadType == 2) {
                selectRoad(2, curRow, curCol, grid, roadType);
                selectRoad(3, curRow, curCol, grid, roadType);
            } else if (roadType == 3) {
                selectRoad(2, curRow, curCol, grid, roadType);
                selectRoad(1, curRow, curCol, grid, roadType);
            } else if (roadType == 4) {
                selectRoad(2, curRow, curCol, grid, roadType);
                selectRoad(0, curRow, curCol, grid, roadType);
            } else if (roadType == 5) {
                selectRoad(3, curRow, curCol, grid, roadType);
                selectRoad(1, curRow, curCol, grid, roadType);
            } else {
                selectRoad(3, curRow, curCol, grid, roadType);
                selectRoad(0, curRow, curCol, grid, roadType);
            }
        }
        return false;
    }

    private boolean inArea(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private void selectRoad(int dir, int curRow, int curCol, int[][] grid, int roadType) {
        int newRow = curRow + directions[dir][0];
        int newCol = curCol + directions[dir][1];
        if (inArea(newRow, newCol)){
            if (dir == 0 && (grid[newRow][newCol] == 2 || grid[newRow][newCol] == 4 || grid[newRow][newCol] == 6)) {
                return;
            } else if (dir == 1 && (grid[newRow][newCol] == 2 || grid[newRow][newCol] == 3 || grid[newRow][newCol] == 5)) {
                return;
            }else if (dir == 2 && (grid[newRow][newCol] == 1 || grid[newRow][newCol] == 3 || grid[newRow][newCol] == 4)){
                return;
            }else if (dir == 3 && (grid[newRow][newCol] == 1 || grid[newRow][newCol] == 5 || grid[newRow][newCol] == 6)){
                return;
            }
            if (!isMarked[newRow][newCol]) {
                queue.push(newRow * cols + newCol);
                isMarked[newRow][newCol] = true;
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{2,4,3},{6,5,2}};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.hasValidPath(grid));
    }
}
