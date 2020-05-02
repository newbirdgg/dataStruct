package data.arraystruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第33题——搜索旋转排序数组
 * @Date: 2020/4/27 7:56
 * @Email: 1031759184@qq.com
 */
public class Solution22 {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return nums[left] == target ? left : -1;
        }
        int mid = left + ((right - left) >> 1);
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < nums[right]) {
            if (nums[mid] < target && nums[right] >= target) {
                return search(nums, mid + 1, right, target);
            } else {
                return search(nums, left, mid - 1, target);
            }
        } else {
            if (nums[left] <= target && target < nums[mid]) {
                return search(nums, left, mid - 1, target);
            } else {
                return search(nums, mid + 1, right, target);
            }
        }

    }




}
