package data.arraystruct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第945题——使数组唯一的最小增量
 * @Date: 2020/3/22 7:15
 * @Email: 1031759184@qq.com
 */
public class Solution8 {
    /*private int count;
    public int minIncrementForUnique(int[] A) {
        if (A.length<2){
            return 0;
        }
        Arrays.sort(A);
        for (int i = 1;i<A.length;i++){
            while (A[i-1]>=A[i]){
                A[i]++;
                count++;
            }
        }
        return count;
    }*/

    public int minIncrementForUnique(int[] A) {
        int[] countArr = new int[40000];
        int count = 0, result = 0;
        for (int i : A) {
            countArr[i]++;
        }
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > 1) {
                count += countArr[i]-1;
                result -= i*(countArr[i]-1);
            }else if (countArr[i]==0&&count>0){
                result += i;
                count--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2};
        Solution8 solution8 = new Solution8();
        System.out.println(solution8.minIncrementForUnique(A));
    }
}
