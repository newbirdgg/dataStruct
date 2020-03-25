package data.math;

import java.util.Random;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第365题——水壶问题
 * @Date: 2020/3/21 7:13
 * @Email: 1031759184@qq.com
 */
public class Solution6 {
    public boolean canMeasureWater(int x, int y, int z) {
        if ((x + y) < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        int c = a > b ? a % b : b % a;
        return c == 0 ? c : gcd(Math.max(a, b), c);
    }

    public static void main(String[] args) {
        int a = 3, b = 5, c = 2;
        int x = 2, y = 6, z = 5;
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.canMeasureWater(a, b, c));
        System.out.println(solution6.canMeasureWater(x, y, z));

    }
}
