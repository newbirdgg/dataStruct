package data.arraystruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第42题——接雨水(快慢指针)
 * @Date: 2020/4/4 7:10
 * @Email: 1031759184@qq.com
 */
public class Solution14 {
    private int slow, fast, rainNum;

    public int trap(int[] height) {
        if (height.length<3) return 0;
        while (height[fast] == 0) {
            fast++;
        }
        slow = fast;
        while (fast != height.length) {
            if (height[fast] >= height[slow]) {
                if (fast - slow > 1){
                    int startHeight = height[slow];
                    while (slow != fast) {
                        slow++;
                        rainNum += startHeight > height[slow] ? startHeight - height[slow] : 0;
                    }
                }else {
                    slow = fast;
                }
            }
            while (fast == height.length - 1 && slow != fast) {
                recursive(height);
            }
            fast++;
        }
        return rainNum;
    }

    private void recursive(int[] height) {
        int max = slow + 1;
        for (int i = max; i <= fast; i++) {
            if (height[i] >= height[max]) {
                max = i;
            }
        }
        int tailHeight = height[max];
        while (slow != max) {
            slow++;
            rainNum += tailHeight > height[slow] ? tailHeight - height[slow] : 0;
        }
    }
}
