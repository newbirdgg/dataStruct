package data.math;
/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第836题——矩形重叠
 *  @Date: 2020/3/18 7:11
 *  @Email: 1031759184@qq.com
 */
public class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return Math.min(rec1[2],rec2[2])>Math.max(rec1[0],rec2[0])&&Math.min(rec1[3],rec2[3])>Math.max(rec1[1],rec2[1]);
    }

    public static void main(String[] args) {
        int[] rec1 = {0,0,1,1};
        int[] rec2 = {1,0,2,1};
        Solution s = new Solution();
        System.out.println(s.isRectangleOverlap(rec1,rec2));
    }
}
