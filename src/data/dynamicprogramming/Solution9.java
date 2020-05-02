package data.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第354题——俄罗斯套娃信封问题
 *  @Date: 2020/4/29 7:57
 *  @Email: 1031759184@qq.com
 */
public class Solution9 {
    private int result;
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length==0) return result;
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0]-o2[0]==0){
                return o2[1]-o1[1];
            }
            return o1[0]-o2[0];
        });
        int[] dp = new int[envelopes.length+1];
        for (int i =0;i<envelopes.length;i++){
            dp[i] = envelopes[i][1];
        }
        for (int height:dp){
            int a = Arrays.binarySearch(dp,0,result,height);
            if (a<0){
                a = -(a+1);
            }
            dp[a] = height;
            if (a == result){
                result++;
            }
        }
        return result;
    }
    
}
