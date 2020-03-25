package data.hashmap;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第5367题——最长快乐前缀
 * @Date: 2020/3/23 8:22
 * @Email: 1031759184@qq.com
 */
public class Solution4 {
    private int result, headHash, tailHash;
    public String longestPrefix(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int times = 1;
        for (int i = 1; i < len; i++, times = (times<<5-times)) {
            headHash = ((headHash<<5)-headHash) + chars[i - 1];
            tailHash += chars[len - i] * times;
            if (headHash == tailHash) {
                result = i;
            }
        }
        return s.substring(0, result);
    }

    static int a;

    public static void main(String[] args) {
        String s = "abab";
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.longestPrefix(s));
    }
}
