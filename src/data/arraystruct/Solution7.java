package data.arraystruct;

import java.util.Arrays;

/**
 *  @Author: liyuzhan
 *  @classDesp： https://leetcode-cn.com/explore/orignial/card/all-about-array/230/define-with-good-care/951/
 *  移除元素
 *  @Date: 2020/3/21 7:59
 *  @Email: 1031759184@qq.com
 */
public class Solution7 {
    public int removeElement(int[] nums, int val) {
        int tail = nums.length-1;
        for (int i = 0;i<=tail;i++){
            while (nums[i]==val){
                swap(i,tail--,nums);
                if (i>tail){
                    break;
                }
            }
        }
        return tail+1;
    }
    private void swap(int a,int b,int[] num){
        int t = num[a];
        num[a] = num[b];
        num[b] = t;
    }

    public static void main(String[] args) {
        int[] num = {3,3};
        int val = 3;
        Solution7 solution7 = new Solution7();
        System.out.println(solution7.removeElement(num,val));

    }
}
