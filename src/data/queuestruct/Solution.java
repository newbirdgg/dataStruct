package data.queuestruct;

import java.util.*;
/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第994题-腐烂的橘子
 *  @Date: 2020/3/5 8:27
 *  @Email: 1031759184@qq.com
 */
public class Solution {
    private static int goodOrange;
    public static int orangesRotting(int[][] grid) {
        LinkedList<Integer> queue = new LinkedList<>();
        if (grid == null) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int size = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    goodOrange++;
                } else if (grid[i][j] == 2) {
                    queue.add(i * cols + j);
                    map.put(i * cols + j,0);
                }
            }
        }
        if (goodOrange == 0) {
            return 0;
        }
        while (!queue.isEmpty()) {
            Integer integer = queue.removeFirst();

            int row = integer / cols;
            int col = integer % cols;
            for (int k = 0; k < 4; k++) {
                int nextRow = row + directions[k][0];
                int nextCol = col + directions[k][1];
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == 1) {
                    grid[nextRow][nextCol] = 2;
                    --goodOrange;
                    queue.addLast(nextRow * cols + nextCol);
                    map.put(nextRow * cols + nextCol,map.get(integer)+1);
                    size = map.get(nextRow * cols + nextCol);
                }
            }
            if (goodOrange == 0){
                break;
            }
        }
        if (goodOrange!=0){
            return -1;
        }

        return size;
    }

    public static void main(String[] args) {
        int[][] test = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(test));
    }

}
