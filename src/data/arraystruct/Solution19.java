package data.arraystruct;
/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第11题——盛最多水的容器
 *  @Date: 2020/4/18 7:25
 *  @Email: 1031759184@qq.com
 */
public class Solution19 {
    private int head,tail,maxArea;
    public int maxArea(int[] height) {
        tail=height.length-1;
        while (head!=tail){
            maxArea = Math.max((tail-head) * Math.min(height[head], height[tail]), maxArea);
            if (height[head]<height[tail]){
                head++;
            }else {
                tail--;
            }
        }
        return maxArea;
    }
}
