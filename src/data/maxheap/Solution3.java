package data.maxheap;

import java.util.Arrays;
import java.util.PriorityQueue;
/**
 * @Author: liyuzhan
 * @classDesp： LeetCode面试题40——最小的k个数
 * @Date: 2020/3/20 7:07
 * @Email: 1031759184@qq.com
 */
public class Solution3 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length < 1 || k < 1 || k > arr.length) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int value : arr) {
            queue.add(value);
        }
        int[] a = new int[k];
        for (int i = 0;i<k;i++){
            if (!queue.isEmpty()){
                a[i] = queue.poll();
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int[] a = {0,0,1,2,4,2,2,3,1,4};
        int k = 8;
        Solution3 solution3 = new Solution3();
        System.out.println(Arrays.toString(solution3.getLeastNumbers(a, k)));
    }
}
