package data.dynamicprogramming;

import java.util.HashMap;

/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第983题——最低票价
 *  @Date: 2020/5/6 7:40
 *  @Email: 1031759184@qq.com
 */
public class Solution10 {
    public int mincostTickets(int[] days, int[] costs) {
        if (days.length==0||costs.length==0) return 0;
        int cost1,cost7,cost30;
        int[] dp = new int[366];
        for (int day:days){
            dp[day] = Integer.MIN_VALUE;
        }
        int day =1;
        while (day<=dp.length-1){
            if (dp[day]!=0){
                cost1 = dp[day-1]+costs[0];
                cost7 = day>7?dp[day-7]+costs[1]:costs[1];
                cost30 = day>30?dp[day-30]+costs[2]:costs[2];
                dp[day] = Math.min(cost1,Math.min(cost7,cost30));
            }else {
                dp[day] = dp[day-1];
            }
            day++;
        }
        return dp[dp.length-1];
    }
}
