package data.bfs;

import java.util.LinkedList;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第200题——岛屿数量（bfs）
 * @Date: 2020/4/20 8:27
 * @Email: 1031759184@qq.com
 */
public class Solution5 {
    private int rows, cols;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] isMarked;
    private LinkedList<Integer> queue;
    private int count;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        isMarked = new boolean[rows][cols];
        queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j]=='1'&&!isMarked[i][j]){
                    queue.add(i*cols+j);
                    isMarked[i][j]=true;
                    count++;
                    while (!queue.isEmpty()){
                        int cur = queue.poll();
                        int curRow = cur/cols;
                        int curCol = cur%cols;
                        for (int k = 0;k<4;k++){
                            int newRow = curRow + direction[k][0];
                            int newCol = curCol + direction[k][1];
                            if (isInArea(newRow,newCol)&&!isMarked[newRow][newCol]&&grid[newRow][newCol]=='1'){
                                queue.offer(newRow*cols+newCol);
                                isMarked[newRow][newCol]=true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    private boolean isInArea(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

}
