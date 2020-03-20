package data.math;

import java.util.Arrays;

/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第260题——只出现一次的数字三
 *  @Date: 2020/3/19 21:39
 *  @Email: 1031759184@qq.com
 */
public class Solution4 {
    private int a,b;
    public int[] singleNumber(int[] nums) {
        if (nums.length<=1){
            return nums;
        }
        for(int i:nums){
            a ^= i;
        }
        int leftNum = a&(~a+1);
        for(int i:nums){
            if ((i&leftNum)!=0){
                b^=i;
            }
        }
        return new int[]{a^b,b};
    }


    public static void main(String[] args) {
        int[] a = {1,2,1,3,2,5};
        Solution4 solution = new Solution4();
        System.out.println(Arrays.toString(solution.singleNumber(a)));
    }
}
