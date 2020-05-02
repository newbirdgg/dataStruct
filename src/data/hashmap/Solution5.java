package data.hashmap;

import java.util.HashMap;
import java.util.Map;
/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第3题——无重复字符的最长子串
 *  @Date: 2020/5/2 8:00
 *  @Email: 1031759184@qq.com
 */
public class Solution5 {
    public int lengthOfLongestSubstring(String s) {
        int result=0;
        int[] hashMap = new int[130];
        char[] chars = s.toCharArray();
        for(int i = 0,j=0;j<chars.length;j++){
            hashMap[chars[j]]++;
            while (hashMap[chars[j]]>1){
                hashMap[chars[i++]]--;
            }
            int count = j-i+1;
            if (count>result){
                result = count;
            }
        }
        return result;
    }
}
