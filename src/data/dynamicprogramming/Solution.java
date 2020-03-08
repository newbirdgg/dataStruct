package data.dynamicprogramming;

import java.util.Arrays;

/**
 * @Author: liyuzhan
 * @classDesp： 力扣第322题-零钱兑换
 * @Date: 2020/3/8 7:16
 * @Email: 1031759184@qq.com
 */
public class Solution {
    int count=Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        coinsChange(coins,coins.length-1,amount,0);
        return count==Integer.MAX_VALUE?-1:count;
    }
    public void coinsChange(int[] coins,int index,int amount,int cnt){
        if(index<0){
            return;
        }
        for(int c=amount/coins[index];c>=0;c--){
            int na=amount-c*coins[index];
            int ncnt=cnt+c;
            if(na==0){
                count=Math.min(count,ncnt);
                break;//剪枝1
            }
            if(ncnt+1>=count){
                break; //剪枝2
            }
            coinsChange(coins,index-1,na,ncnt);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {2,5,10,1};
        int amount = 27;
        int i = solution.coinChange(coins, amount);
        System.out.println(i);
    }

}
