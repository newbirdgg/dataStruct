package data.dynamicprogramming;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第221题——最大正方形
 * @Date: 2020/5/8 7:52
 * @Email: 1031759184@qq.com
 */
public class Solution11 {
    private int rows, cols, result;
    private int[][] dpTable;

    public int maximalSquare(char[][] matrix) {
        rows = matrix.length;
        if (rows==0) return result;
        cols = matrix[0].length;
        if (cols == 0) return result;
        dpTable = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j]=='1'){
                    if (i != 0 && j != 0) {
                        dpTable[i][j] = Math.min(dpTable[i-1][j],Math.min(dpTable[i][j-1],dpTable[i-1][j-1]))+1;
                    }else {
                        dpTable[i][j]=1;
                    }
                    result = Math.max(result,dpTable[i][j]);
                }
            }
        }
        return (int) Math.pow(result,2);
    }
}
