package data.arraystruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第1013题-将数组分成和相等的三个部分
 * @Date: 2020/3/11 7:14
 * @Email: 1031759184@qq.com
 */
public class Solution3 {
    static int sum1, sum2, total;

    public static boolean canThreePartsEqualSum(int[] A) {
        if (A.length < 3) {
            return false;
        }
        //如果分成三个相等的部分，那每一部分是总和1/3
        for (int a : A) {
            total += a;
        }
        if (total % 3 == 0) {
            sum1 = A[0];
            sum2 = A[A.length - 1];
            for (int i = 0, j = A.length - 1; i < j - 1; ) {
                if (sum1 == total / 3 && sum2 == total / 3) {
                    int sum3 = 0;
                    if (sum1 == 0) {
                        for (int a = i + 1; a < j; a++) {
                            sum3 += A[a];
                        }
                        return sum3 == 0 ? true : false;
                    }
                    return true;
                }
                if (sum1 != total / 3) {
                    i++;
                    sum1 += A[i];
                }
                if (sum2 != total / 3) {
                    j--;
                    sum2 += A[j];
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {0,2,1,-6,6,-7,9,1,2,0,1};
        System.out.println(canThreePartsEqualSum(A));
    }
}
