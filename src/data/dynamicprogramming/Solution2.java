package data.dynamicprogramming;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第121题-买卖股票最佳时机
 * @Date: 2020/3/9 7:16
 * @Email: 1031759184@qq.com
 */
public class Solution2 {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int result = 0;
        int minValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int newRe = prices[i]-minValue;
            result = newRe>result?newRe:result;
            minValue = minValue>prices[i]?prices[i]:minValue;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
