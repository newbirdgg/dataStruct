package data.dynamicprogramming;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode面试题17.16——按摩师
 * @Date: 2020/3/24 7:13
 * @Email: 1031759184@qq.com
 */
public class Solution6 {
    public int massage(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int maxresult = Math.max(nums[0], nums[1]);
        if (nums.length == 2) {
            return maxresult;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = maxresult;
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,4,5};
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.massage(nums));
    }
}
