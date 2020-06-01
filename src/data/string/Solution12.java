package data.string;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第5题——最长回文子串
 * @Date: 2020/5/21 7:44
 * @Email: 1031759184@qq.com
 */
public class Solution12 {
    public String longestPalindrome(String s) {
        if (s.length() < 1) return s;
        char[] chars = s.toCharArray();
        int head = 0, tail = 0;
        for (int i = 0; i < chars.length; i++) {
            int max = Math.max(palindrome(i, i, chars), palindrome(i, i + 1, chars));
            if (max > tail - head) {
                head = i - ((max - 1) >> 1);
                tail = i + (max >> 1);
            }
        }
        return s.substring(head,++tail);
    }

    private int palindrome(int l, int r, char[] chars) {
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            --l;
            ++r;
        }
        return r - l - 1;
    }
}
