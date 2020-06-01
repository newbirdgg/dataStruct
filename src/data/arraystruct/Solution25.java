package data.arraystruct;
/**
 *  @Author: liyuzhan
 *  @classDesp：
 *  @Date: 2020/5/3 9:41
 *  @Email: 1031759184@qq.com
 */
public class Solution25 {
    private int sum,result = Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {
        if (nums.length==0)return 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            result = Math.max(result, sum);
        }
        return result;
    }
}
