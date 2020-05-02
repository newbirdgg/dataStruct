package data.arraystruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第55题——跳跃游戏
 * @Date: 2020/4/17 8:02
 * @Email: 1031759184@qq.com
 */
public class Solution18 {
    private int maxJump, index=1;

    public boolean canJump(int[] nums) {
        if (nums.length == 0) return false;
        maxJump = nums[0];
        while (--maxJump>=0) {
            if (index == nums.length - 1) {
                return true;
            }
            if (nums[index] >= maxJump) {
                maxJump = nums[index];
            }
            index++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,2,0,1,1};
        Solution18 s = new Solution18();
        s.canJump(a);
    }

}
