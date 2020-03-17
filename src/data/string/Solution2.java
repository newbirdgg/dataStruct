package data.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode面试题01.06——字符串压缩
 * @Date: 2020/3/16 7:17
 * @Email: 1031759184@qq.com
 */
public class Solution2 {
    int top, tail, count;

    public String compressString(String S) {
        int size = S.length();
        if (size <= 1) {
            return S;
        }
        StringBuilder res = new StringBuilder();
        char[] array = S.toCharArray();
        while (tail != size) {
            if (array[top] == array[tail]) {
                count++;
                tail++;
            } else {
                res.append(array[top]).append(count);
                count = 0;
                top = tail;
            }
            if (tail == size - 1 && array[top] == array[tail]) {
                res.append(array[tail]).append(tail - top + 1);
            }

        }
        return size <= res.length() ? S : res.toString();
    }
//    public String compressString(String S) {
//        StringBuilder sb = new StringBuilder();
//        char[] cs = S.toCharArray();
//        int count = 0;
//        for (int i = 0; i < cs.length; ++i) {
//            ++count;
//            if (i == cs.length - 1 || cs[i] != cs[i + 1]) {
//                sb.append(cs[i]).append(count);
//                count = 0;
//            }
//        }
//        if (sb.length() >= S.length()) {
//            return S;
//        }
//        return sb.toString();
//    }
    public static void main(String[] args) {
        String s = "abca";
        Solution2 solution = new Solution2();
        System.out.println(solution.compressString(s));
    }
}
