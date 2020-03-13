package data.arraystruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第169题-多数运算
 * @Date: 2020/3/13 7:42
 * @Email: 1031759184@qq.com
 */
public class Solution4 {

    public int majorityElement(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private int divideAndConquer(int[] array, int left, int right) {
        if (left == right) {
            return array[left];
        }
        int mid = ((right - left) >> 1) + left;
        int leftDivide = divideAndConquer(array, left, mid);
        int rightDivide = divideAndConquer(array, mid + 1, right);
        if (leftDivide == rightDivide) {
            return leftDivide;
        }
        int leftModeCount = searchMode(array, left, right, leftDivide);
        int rightModeCount = searchMode(array, left, right, rightDivide);
        return leftModeCount > rightModeCount ? leftDivide : rightDivide;
    }

    private int searchMode(int[] array, int left, int right, int mode) {
        int modeCount = 0;
        for (int i = left; i <= right; i++) {
            if (array[i] == mode) {
                modeCount++;
            }
        }
        return modeCount;
    }

    public static void main(String[] args) {
        Solution4 s = new Solution4();
        int[] array = {3, 3, 4};
        System.out.println(s.majorityElement(array));
    }
}
