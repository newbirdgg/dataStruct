package data.dynamicprogramming;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第300题-最长上升子序列
 * @Date: 2020/3/14 11:03
 * @Email: 1031759184@qq.com
 */
public class Solution3 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}
