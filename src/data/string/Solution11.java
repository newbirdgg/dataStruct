package data.string;

import java.util.Arrays;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第1371题——每个元音包含偶数次的最长字符串
 * @Date: 2020/5/20 7:48
 * @Email: 1031759184@qq.com
 */
public class Solution11 {
    public int findTheLongestSubstring(String s) {
        int hash = 0, result = 0;
        int[] hashMap = new int[33];
        Arrays.fill(hashMap, Integer.MIN_VALUE);
        hashMap[0] = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hash = c == 'a' ? hash ^ 1
                    : c == 'e' ? hash ^ (1 << 1)
                    : c == 'i' ? hash ^ (1 << 2)
                    : c == 'o' ? hash ^ (1 << 3)
                    : c == 'u' ? hash ^ (1 << 4)
                    : hash;
            if (hashMap[hash] == Integer.MIN_VALUE) {
                hashMap[hash] = i;
            } else {
                result = Math.max(result, i - hashMap[hash]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "leetcodeisgreat";
        Solution11 a = new Solution11();
        a.findTheLongestSubstring(s);
    }
}
