package data.arraystruct;

/**
 * @Author: liyuzhan
 * @classDesp： 对于一个无序数组A，请设计一个算法，求出需要排序的最短子数组的长度。
 * 给定一个整数数组A及它的大小n，请返回最短子数组的长度。
 * @Date: 2020/3/20 22:18
 * @Email: 1031759184@qq.com
 */
public class Solution6 {
    public int findShortest(int[] A, int n) {
        if (n<2){
            return 0;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] A = {1,5,3,4,2,6,7};
        int n = 7;
        Solution6 solution6 = new Solution6();
        solution6.findShortest(A,n);
    }
}
