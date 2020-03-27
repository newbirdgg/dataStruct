package data.arraystruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第914题——卡牌分组
 * @Date: 2020/3/27 7:07
 * @Email: 1031759184@qq.com
 */
public class Solution12 {
    private int count = Integer.MAX_VALUE;

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1) {
            return false;
        }
        int[] a = new int[1000];
        for (int i : deck) {
            a[i]++;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                if (count == Integer.MAX_VALUE) {
                    count = a[i];
                }
                int gcd = a[i] > count ? gcd(a[i], count) : gcd(count, a[i]);
                if (gcd == 1) {
                    return false;
                }
                count = Math.max(a[i], count);
            }
        }
        return true;
    }

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
