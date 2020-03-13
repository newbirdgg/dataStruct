package data.string;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第1071题-字符串最大公因子
 * @Date: 2020/3/12 7:47
 * @Email: 1031759184@qq.com
 */
public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd1(str1.length(), str2.length()));

    }

    /**
     * 欧几里得最大公约数算法（辗转相除）
     * 如果str1和str2满足含有最大公约数，那他们的字符串一定满足a+b=b+a
     * 当满足条件的时候就只需要找到他们之间的长度的最大公约数就可以
     *
     * @param m
     * @param n
     * @return
     */
    private int gcd(int m, int n) {
        if (m < n) {
            int k = m;
            m = n;
            n = k;
        }
        return m % n == 0 ? n : gcd(n, m % n);
    }

    private int gcd1(int m, int n) {
        int t;
        t = Math.min(m, n);
        while (m % t != 0 || n % t != 0) {
            t--;
        }
        return t;
    }

    public static void main(String[] args) {
        String a = "ABABAB";
        String b = "ABAB";
        Solution s = new Solution();
        System.out.println(s.gcdOfStrings(a, b));
    }
}
