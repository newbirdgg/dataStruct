package data.arraystruct;

import java.util.LinkedList;


/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第84题——柱状图中最大矩阵
 *  @Date: 2020/5/30 6:54
 *  @Email: 1031759184@qq.com
 */
public class Solution31 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length==0) return 0;
        if (heights.length==1) return heights[0];
        LinkedList<Integer> stack = new LinkedList<>();
        int[] newHeights = new int[heights.length+1];
        System.arraycopy(heights, 0, newHeights, 0, heights.length);
        int result = 0;
        for (int i = 0;i<newHeights.length;i++){
            while (!stack.isEmpty()&&newHeights[stack.peekLast()]>newHeights[i]){
                int curNum = stack.removeLast();
                result = Math.max(result,newHeights[curNum]*(i-(stack.peekLast()==null?0:stack.peekLast()+1)));
            }
            stack.addLast(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,1};
        Solution31 s= new Solution31();
        s.largestRectangleArea(a);
    }
}
