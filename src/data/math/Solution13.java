package data.math;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第50题——Pow(x,n)
 * @Date: 2020/5/11 8:55
 * @Email: 1031759184@qq.com
 */
public class Solution13 {
    public double myPow(double x, int n) {
        double res = -1;
        int temp = n > 0 ? n : -n;
        while (temp != 0) {
            int lastBit = getLastBit(temp);
            res = res == -1 ? calculation(x, lastBit) : res * calculation(x, lastBit);
            temp -= lastBit;
        }
        return n >= 0 ? res : 1 / res;
    }

    private int getLastBit(int num) {
        return num & (~num + 1);
    }

    private double calculation(double num, int pow) {
        double res = 1;
        for (int i = 1; i <= pow; i++) {
            res *= num;
        }
        return res;
    }
}
