package data.arraystruct;

import java.math.BigInteger;
import java.util.List;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第5376——非递增的最小子序列
 * @Date: 2020/4/5 10:31
 * @Email: 1031759184@qq.com
 */
public class Solution16 {
//    public int numSteps(String s) {
//        int count = 0;
//        BigInteger result = new BigInteger(s,2);
//
//        while (result.compareTo(new BigInteger("1"))!=0) {
//            BigInteger[] resBigIntegers = result.divideAndRemainder(new BigInteger("2"));
//            result = resBigIntegers[1].equals(new BigInteger("0"))?resBigIntegers[0]:result.add(new BigInteger("1"));
//            count++;
//        }
//        return count;
//    }

    public String longestDiverseString(int a, int b, int c) {
        int total = a + b + c;
        if (total == a || total == b || total == c) {
            return "";
        }
        int max = Math.max(a, Math.max(b, c));
        int medium = Math.min(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        char maxChar = a == max ? 'a' : b == max ? 'b' : 'c';
        char mediumChar = a == medium && maxChar != 'a' ? 'a' : b == medium && maxChar != 'b' ? 'b' : 'c';
        char minChar = a == min && maxChar != 'a' && mediumChar != 'a' ? 'a' : b == min && maxChar != 'b' && mediumChar != 'b' ? 'b' : 'c';
        StringBuilder result = new StringBuilder();
        int count = 0;
        while (true) {
            while (count < 2 && max !=0) {
                result.append(maxChar);
                count++;
                max--;
            }
            if (medium==0&&min==0){
                break;
            }
            count = 0;


            while (count < 2 && medium != 0) {
                result.append(mediumChar);
                count++;
                medium--;
            }
            count = 0;


        }
        return result.toString();
    }

    public static void main(String[] args) {
        int a=1,b=1,c=7;
        Solution16 s= new Solution16();
        System.out.println(s.longestDiverseString(a,b,c));
    }
}
