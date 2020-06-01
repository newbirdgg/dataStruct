package data.dynamicprogramming;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第198题——打家劫舍
 * @Date: 2020/5/29 8:02
 * @Email: 1031759184@qq.com
 */
public class Solution13 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            int moneyCount = dp[i - 2] + nums[i - 1];
            dp[i] = Math.max(dp[i - 1], moneyCount);
        }
        return dp[nums.length];
    }
}
