package data.arraystruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第1248题——统计优美子数组
 * @Date: 2020/4/21 8:04
 * @Email: 1031759184@qq.com
 */
public class Solution20 {
    private int result, odd;
    private int[] countArr;

    public int numberOfSubarrays(int[] nums, int k) {
        countArr = new int[nums.length+1];
        countArr[0] = 1;
        for (int num : nums) {
            odd += num & 1;
            result += odd >= k ? countArr[odd - k] : 0;
            countArr[odd] += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1,1};
        int k = 3;
        Solution20 s = new Solution20();
        s.numberOfSubarrays(nums,k);
    }
}
