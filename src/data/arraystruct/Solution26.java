package data.arraystruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第45题——跳跃游戏②
 * @Date: 2020/5/4 7:48
 * @Email: 1031759184@qq.com
 */
public class Solution26 {
    private int maxJump, index = 1, count = 1, startJump = 0;

    public int jump(int[] nums) {
        int start = 0, end = 0, count = 0;
        while (end < nums.length - 1) {
            int max = end;
            for (int i = start; i <= end; i++) {
                if (nums[i] + i > max)
                    max = nums[i] + i;
            }
            start = end + 1;
            end = max;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {7, 0, 9, 6, 4, 7, 9, 0, 1, 2, 9, 0, 3};
        Solution26 s = new Solution26();
        s.jump(a);
    }
}
