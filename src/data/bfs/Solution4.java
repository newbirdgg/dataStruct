package data.bfs;

import data.queuestruct.Queue;

import java.util.LinkedList;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第542题——01矩阵
 * @Date: 2020/4/15 9:00
 * @Email: 1031759184@qq.com
 */
public class Solution4 {
    private int[][] direction;
    private int rows, cols, distance;
    private LinkedList<Integer> queue;
    private boolean[][] isMark;

    public int[][] updateMatrix(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        queue = new LinkedList<>();
        direction = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        distance = 1;
        isMark = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(i * cols + j);
                    isMark[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0;i<size;i++){
                int cur = queue.poll();
                int curRow = cur / cols;
                int curCol = cur % cols;
                for (int k = 0; k < 4; k++) {
                    int newRow = curRow + direction[k][0];
                    int newCol = curCol + direction[k][1];
                    if (inArea(newRow, newCol) && !isMark[newRow][newCol]) {
                        if (matrix[newRow][newCol] != 0) {
                            matrix[newRow][newCol] = distance;
                        }
                        queue.offer(newRow * cols + newCol);
                        isMark[newRow][newCol] = true;
                    }
                }
            }
            distance++;
        }
        return matrix;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }

    public static void main(String[] args) {
        int[][] a = {{0,0,0},{0,1,0},{0,0,0}};
        Solution4 s = new Solution4();
        s.updateMatrix(a);
    }

}
