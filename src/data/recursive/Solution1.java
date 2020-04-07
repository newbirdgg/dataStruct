package data.recursive;
/**
 *  @Author: liyuzhan
 *  @classDesp： 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0
 *  @Date: 2020/3/20 10:02
 *  @Email: 1031759184@qq.com
 */
public class Solution1 {
    public int Fibonacci(int n) {
        if (n==0){
            return 0;
        }
        if (n<=2){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public static void main(String[] args) {
        int n = 20;
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.Fibonacci(n));
    }
}
