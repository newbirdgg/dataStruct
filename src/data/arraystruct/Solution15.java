package data.arraystruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第42题——接雨水（官方双指针法）
 * @Date: 2020/4/4 8:21
 * @Email: 1031759184@qq.com
 */
public class Solution15 {
    private int left, right, leftMax, rightMax, rainNum;

    public int trap(int[] height) {
        right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    rainNum += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    rainNum += rightMax - height[right];
                }
                right--;
            }
        }
        return rainNum;
    }
}
