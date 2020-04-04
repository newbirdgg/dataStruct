package data.stackstruct;

import data.sort.Solution2;

import java.util.Arrays;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第1111题——有效括号的嵌套深度
 * @Date: 2020/4/1 7:11
 * @Email: 1031759184@qq.com
 */
public class Solution1 {
    private int[] result;
    private int count;

    public int[] maxDepthAfterSplit(String seq) {
        result = new int[seq.length()];
        char[] chars = seq.toCharArray();
        recursive(chars, 0);
        return result;
    }

    private void recursive(char[] chars, int index) {
        if (count == chars.length) return;
        if (chars[count] == '(') {
            result[count++] = index % 2;
            index++;
        } else {
            result[count++] = index % 2 == 0 ? 1 : 0;
            if (index!=0){
                index--;
            }
        }
        recursive(chars, index);
    }

    public static void main(String[] args) {
        String s = "()(())()";
        Solution1 s1 = new Solution1();
        System.out.println(Arrays.toString(s1.maxDepthAfterSplit(s)));
    }
}
