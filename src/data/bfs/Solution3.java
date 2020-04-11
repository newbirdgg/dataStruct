package data.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode面试题13——机器人的运动范围
 * @Date: 2020/4/8 7:15
 * @Email: 1031759184@qq.com
 */
public class Solution3 {
    public int movingCount(int m, int n, int k) {
        int result = 1;
        if (k < 1) {
            return result;
        }
        boolean[][] isMark = new boolean[m][n];
        Queue<Integer> queue = new LinkedList<>();
        int[][] direction = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        queue.offer(0);
        isMark[0][0] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curRow = cur / n;
            int curCol = cur % n;
            for (int dir = 0; dir < 4; dir++) {
                int newRow = curRow + direction[dir][0];
                int newCol = curCol + direction[dir][1];
                if (inArea(newRow, newCol, m, n) && canMove(newRow, newCol, k) && !isMark[newRow][newCol]) {
                    queue.offer(newRow * n + newCol);
                    isMark[newRow][newCol] = true;
                    result++;
                }
            }
        }
        return result;
    }

    private boolean canMove(int x, int y, int k) {
        int ans = 0;
        while (x != 0) {
            ans += x % 10;
            x /= 10;
        }
        while (y != 0) {
            ans += y % 10;
            y /= 10;
        }
        return ans <= k;
    }

    private boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }

    public static void main(String[] args) {
        int a = 11, b = 8, c = 16;
        Solution3 s = new Solution3();
        System.out.println(s.movingCount(a, b, c));
    }
}
