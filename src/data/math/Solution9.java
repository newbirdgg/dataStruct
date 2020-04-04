package data.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: liyuzhan
 * @classDesp： leet面试62题——圆圈中最后剩下的数字
 * @Date: 2020/3/30 7:08
 * @Email: 1031759184@qq.com
 */
public class Solution9 {
    private int result;

    public int lastRemaining(int n, int m) {
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5, m = 3;
        Solution9 s = new Solution9();
        System.out.println(s.lastRemaining(n,m));
    }
}
