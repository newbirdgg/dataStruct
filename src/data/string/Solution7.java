package data.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第22题——括号生成
 * @Date: 2020/4/9 7:17
 * @Email: 1031759184@qq.com
 */
public class Solution7 {
    private StringBuilder stringBuilder;
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) return res;
        stringBuilder= new StringBuilder();
        dfs(0, 0, n, res);
        return res;
    }

    private void dfs(int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(stringBuilder.toString());
            return;
        }
        if (left < right) return;
        if (left < n) {
            stringBuilder.append("(");
            dfs(left + 1, right, n, res);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if (right < n) {
            stringBuilder.append(")");
            dfs(left, right + 1, n, res);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }


    public static void main(String[] args) {
        int i = 3;
        Solution7 s = new Solution7();
        System.out.println(s.generateParenthesis(i));
    }
}
