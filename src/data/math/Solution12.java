package data.math;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第69题——x的平方根
 * @Date: 2020/5/9 8:20
 * @Email: 1031759184@qq.com
 */
public class Solution12 {
    public int mySqrt(int x) {
        int left=0,right=x,mid,result=0;
        while (left<=right){
            mid = left+((right-left)>>1);
            if (Math.pow(mid,2)<=x){
                result = mid;
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return result;
    }
}
