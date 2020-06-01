package data.arraystruct;

import java.util.HashMap;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第560题——和为k的子数组
 * @Date: 2020/5/15 8:23
 * @Email: 1031759184@qq.com
 */
public class Solution27 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                count++;
            }
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,2,3,4,5,6,1,1,65,3,1,2,1,2};
        Solution27 s = new Solution27();
        s.subarraySum(a,2);
    }
}
