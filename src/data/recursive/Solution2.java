package data.recursive;
/**
 *  @Author: liyuzhan
 *  @classDesp： 备忘录改进版斐波那契数列
 *  @Date: 2020/4/6 10:15
 *  @Email: 1031759184@qq.com
 */
public class Solution2 {
    public int fib(int n){
        if (n<1) return 0;
        int[] memo = new int[n+1];
        return helper(memo,n);
    }

    private int helper(int[] memo,int n){
        if (n==1||n==2) return 1;
        if (memo[n]!=0) return memo[n];

        memo[n] = helper(memo,n-1)+helper(memo,n-2);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 20;
        Solution2 s = new Solution2();
        System.out.println(s.fib(n));
    }
}
