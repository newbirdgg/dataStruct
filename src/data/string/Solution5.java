package data.string;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第8题——字符串转整数
 * @Date: 2020/4/3 7:07
 * @Email: 1031759184@qq.com
 */
public class Solution5 {
    private char operator;
    private long num;
    private boolean findOpera;
    private boolean findNum;

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (isword(ch) || ((findOpera || findNum) && (isOpera(ch) || ch == 32))) {
                break;
            }
            if (isOpera(ch)) {
                findOpera = true;
                operator = ch;
            }
            if (isNum(ch)) {
                findNum = true;
                num = num * 10 + (ch - '0');
                if (num > Integer.MAX_VALUE) {
                    break;
                }
            }
        }
        num = num < Integer.MAX_VALUE ? operator == 45 ? -num : num : operator == 45 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        return (int) num;
    }


    private boolean isword(char ch) {
        return ch != 32 && ch != 45 && ch != 43 && (ch < 48 || ch > 57);
    }

    private boolean isOpera(char ch) {
        return ch == 45 || ch == 43;
    }

    private boolean isNum(char ch) {
        return ch >= 48 && ch <= 57;
    }

    public static void main(String[] args) {
        String a = "-11111111111111111111111111111111111111";
        Solution5 s = new Solution5();
        System.out.println(s.myAtoi(a));
        System.out.println(Math.pow(2, 31) - 1);
    }
}
