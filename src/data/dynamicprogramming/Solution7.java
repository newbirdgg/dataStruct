package data.dynamicprogramming;

import java.util.ArrayList;

/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第887题——鸡蛋掉落
 *  @Date: 2020/4/11 7:20
 *  @Email: 1031759184@qq.com
 */
public class Solution7 {
    public int superEggDrop(int K, int N) {
        int[] dp = new int[K + 1];
        while (dp[K] < N){
            for (int i = K; i > 0; i--) {
                dp[i] += dp[i-1] + 1;
            }
        }
        return dp[1];
    }
}
