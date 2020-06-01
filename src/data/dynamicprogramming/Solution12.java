package data.dynamicprogramming;
/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第152题——积乘最大子数组
 *  @Date: 2020/5/18 7:53
 *  @Email: 1031759184@qq.com
 */
public class Solution12 {
    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        int curMax = 1,curMin = 1;
        int[] dp = new int[nums.length+1];
        dp[0] = Integer.MIN_VALUE;
        for (int i = 1;i<=nums.length;i++){
            int cur = curMax;
            curMax = nums[i-1]<0?Math.max(curMin*nums[i-1],nums[i-1]):Math.max(curMax*nums[i-1],nums[i-1]);
            curMin = nums[i-1]<0?Math.min(cur*nums[i-1],nums[i-1]):Math.min(curMin*nums[i-1],nums[i-1]);
            dp[i] = Math.max(dp[i-1],curMax);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] a = {-4,-25,-3};
        Solution12 s = new Solution12();
        s.maxProduct(a);
    }

}
