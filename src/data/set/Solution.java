package data.set;

import java.util.TreeSet;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第804题-唯一摩尔斯密码词
 * @Date: 2020/2/29 21:10
 * @Email: 1031759184@qq.com
 */
public class Solution {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i) - 'a']);
            }
            set.add(res.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] strings = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(strings));
    }

}
