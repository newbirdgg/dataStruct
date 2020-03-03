package data.arraystruct;

import java.util.Arrays;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode数组题，合并两个数组
 * @Date: 2020/3/3 8:55
 * @Email: 1031759184@qq.com
 */
class Solution {
    public static void merge(int[] A, int m, int[] B, int n) {
        int tail = m + n - 1;
        while (n > 0) {
            if (m != 0 && A[m - 1] >= B[n - 1]) {
                A[tail] = A[m - 1];
                m--;
                tail--;
            } else {
                A[tail] = B[n - 1];
                n--;
                tail--;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {0, 0, 0};
        int m = 0;
        int[] B = {2, 4, 5};
        int n = 3;
        merge(A, m, B, n);
        System.out.println(Arrays.toString(A));
    }
}
