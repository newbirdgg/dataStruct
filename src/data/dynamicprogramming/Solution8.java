package data.dynamicprogramming;
/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode 面试题08.11.硬币
 *  @Date: 2020/4/23 7:52
 *  @Email: 1031759184@qq.com
 */
public class Solution8 {

    public int waysToChange(int n) {
        int[] dp=new int[n+1];
        int[] coins={1,5,10,25};

        for(int i=0;i<=n;i++)
            dp[i]=1;

        for(int i=1;i<4;i++){
            for(int j=1;j<=n;j++){
                if(j>=coins[i])
                    dp[j]=(dp[j]+dp[j-coins[i]])%1000000007;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int a = 10;
        Solution8 s = new Solution8();
        System.out.println(s.waysToChange(a));
    }
}
