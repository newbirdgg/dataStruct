package data.arraystruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode面试01.07——旋转矩阵
 * @Date: 2020/4/7 7:14
 * @Email: 1031759184@qq.com
 */
public class Solution17 {
    private int rows, cols, save = Integer.MAX_VALUE;

    public void rotate(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        int headIndex = 0, tailIndex = cols - 1;
        for (int row = 0; row < (rows >> 1); row++) {
            for (int col = headIndex; col < (cols-(headIndex+1)); col++){
                swap(matrix,row*cols+col,col*cols+(tailIndex-headIndex));
                swap(matrix,0,(tailIndex-headIndex)*cols+(tailIndex-col));
                swap(matrix,0,(tailIndex-col)*cols+headIndex);
                swap(matrix,0,headIndex*cols+col);
                save = Integer.MAX_VALUE;
            }
            headIndex++;
        }

    }

    private void swap(int[][] matrix, int x, int y) {
        int newRow1 = x / cols;
        int newCol1 = x % cols;
        int newRow2 = y / cols;
        int newCol2 = y % cols;
        if (save == Integer.MAX_VALUE) {
            save = matrix[newRow2][newCol2];
            matrix[newRow2][newCol2] = matrix[newRow1][newCol1];
        } else {
            int t = matrix[newRow2][newCol2];
            matrix[newRow2][newCol2] = save;
            save = t;
        }

    }

    public static void main(String[] args) {
        int[][] a = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        Solution17 s = new Solution17();
        s.rotate(a);
    }
}
