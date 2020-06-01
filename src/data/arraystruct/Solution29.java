package data.arraystruct;

import java.util.Arrays;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第287题——寻找重复数
 * @Date: 2020/5/26 7:56
 * @Email: 1031759184@qq.com
 */
public class Solution29 {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1, result = 0;
        while (left <= right) {
            int mid = left+((right-left) >> 1);
            int count = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] <= mid)++count;
            }
            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 3, 4, 2};
        Solution29 s = new Solution29();
        s.findDuplicate(a);
    }
}
