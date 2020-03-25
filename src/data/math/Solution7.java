package data.math;
/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第5178题
 *  @Date: 2020/3/23 8:02
 *  @Email: 1031759184@qq.com
 */
public class Solution7 {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += getOne(i);
        }
        return sum;
    }

    private int getOne(int num) {
        if((int)Math.sqrt(num) == Math.sqrt(num)) {
            return 0;
        }
        int sum = 0;
        int count = 0;
        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
                count++;
            }
            if (count > 1) {
                return 0;
            }
        }
        return count == 1 ? sum + 1 + num : 0;
    }

}
