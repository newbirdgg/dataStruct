package data.math;
/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第409题——最长回文串(贪心解法)
 * @Date: 2020/3/19 7:12
 * @Email: 1031759184@qq.com
 */
public class Solution3 {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray()) {
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
