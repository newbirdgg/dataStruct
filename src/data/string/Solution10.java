package data.string;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第680题——验证回文字符串
 * @Date: 2020/5/19 7:52
 * @Email: 1031759184@qq.com
 */
public class Solution10 {
    private boolean isDelete;

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int tail = chars.length - 1, head = 0;
        while (head < tail) {
            if (chars[head] != chars[tail]) {
                if (isDelete) return false;
                isDelete = true;
                return chars[head + 1] == chars[tail] && validPalindrome(s.substring(head + 1, tail + 1))
                        || chars[tail - 1] == chars[head] && validPalindrome(s.substring(head, tail));
            } else {
                --tail;
                ++head;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        Solution10 a = new Solution10();
        a.validPalindrome(s);
    }
}
