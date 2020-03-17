package data.arraystruct;
/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode-移动零
 *  @Date: 2020/3/17 8:49
 *  @Email: 1031759184@qq.com
 */
public class Solution5 {
    private int head;
    public void moveZeroes(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            if (nums[i]!=0){
                int a = nums[head];
                nums[head] = nums[i];
                nums[i] = a;
                head++;
            }
        }
    }
}
