package data.hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第387题——字符串中的第一个唯一的字符
 * @Date: 2020/3/17 9:01
 * @Email: 1031759184@qq.com
 */
public class Solution {
    public int firstUniqChar(String s) {
        if (s.length() < 1) {
            return -1;
        }
        int[] c = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            int index = ch - 'a';
            c[index]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (c[chars[i]-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
