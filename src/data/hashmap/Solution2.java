package data.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第409题——最长回文串
 * @Date: 2020/3/19 7:12
 * @Email: 1031759184@qq.com
 */
public class Solution2 {
    private int result, keyCount;

    public int longestPalindrome(String s) {

        if (s.length() <= 1) {
            return s.length();
        }
        char[] array = s.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>(16);
        for (char ch : array) {
            if (!hashMap.containsKey(ch)) {
                hashMap.put(ch, 1);
            } else {
                hashMap.put(ch, hashMap.get(ch) + 1);
            }
        }
        hashMap.forEach(
                (k, v) -> {
                    if ((hashMap.get(k)&1)==0) {
                        result += hashMap.get(k);
                    }
                    if ((hashMap.get(k)&1)>0){
                        result+=hashMap.get(k)-1;
                        keyCount = 1;
                    }
                }
        );
        return result+keyCount;
    }

    public static void main(String[] args) {
        String s = "abcccccddzzz";
        Solution2 solution = new Solution2();
        System.out.println(solution.longestPalindrome(s));

    }
}
