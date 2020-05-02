package data.arraystruct;
/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode面试题56-1.数组中数字出现的次数
 *  @Date: 2020/4/28 8:05
 *  @Email: 1031759184@qq.com
 */
public class Solution23 {
    public int[] singleNumbers(int[] nums) {
        int a = 0;
        for (int i = 0;i<nums.length;i++){
            a^=nums[i];
        }
        //0100
        int right = a & (~a+1);
        int b = 0;
        for (int i = 0;i<nums.length;i++){
            if ((nums[i]&right)!=0){
                b^=nums[i];
            }
        }
        return new int[]{b,a^b};
    }

    public static void main(String[] args) {
        int[] a = {1,2,5,2};
        Solution23 s = new Solution23();
        s.singleNumbers(a);
    }
}
