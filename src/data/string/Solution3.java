package data.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第1160题——拼写单词(hashMap解法)
 * @Date: 2020/3/17 7:14
 * @Email: 1031759184@qq.com
 */
public class Solution3 {
    private int i, countLength;

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> hashMap = new HashMap<>(16);

        for (Character c : chars.toCharArray()) {
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, 1);
            } else {
                hashMap.put(c, hashMap.get(c) + 1);
            }
        }
        for (String s : words) {
            Map<Character, Integer> countMap = new HashMap<>(16);
            char[] charArray = s.toCharArray();
            if (contain(charArray, charArray[i], hashMap,countMap)) {
                countLength += s.length();
            }
        }
        return countLength;
    }

    private boolean contain(char[] charArray, char c, Map<Character, Integer> hashMap,Map<Character, Integer> countMap) {
        if (hashMap.containsKey(c)&&!hashMap.get(c).equals(countMap.get(c))) {
            if (!countMap.containsKey(c)){
                countMap.put(c,1);
            }else {
                countMap.put(c,countMap.get(c)+1);
            }
            if (i == charArray.length - 1) {
                i = 0;
                return true;
            }
            return contain(charArray, charArray[++i], hashMap,countMap);
        }
        i = 0;
        return false;
    }

    public static void main(String[] args) {
        String[] s = {"cat","bt","hat","tree"};
        String c = "atach";
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.countCharacters(s, c));
    }
}
