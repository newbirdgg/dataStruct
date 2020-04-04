package data.sort;


import java.util.Arrays;
import java.util.Random;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第912题——排序数组
 * @Date: 2020/3/31 7:06
 * @Email: 1031759184@qq.com
 */
public class Solution2 {
    private Random random = new Random();
    public int[] sortArray(int[] nums) {
        partition(nums, 0, nums.length - 1);
        return nums;
    }

    public void partition(int[] nums, int left, int right) {
        if (left < right) {
            int[] p = quickSort(nums, left, right);
            partition(nums, left, p[0] - 1);
            partition(nums, p[1] + 1, right);
        }
    }


    public int[] quickSort(int[] nums, int left, int right) {
        int sortNum = left+1+random.nextInt(right-left);
        swap(nums,sortNum,right);
        int less = left - 1;
        int more = right;
        int cur = left;
        while (cur < more) {

            if (nums[cur] < nums[right]) {
                swap(nums, ++less, cur++);
            } else if (nums[cur] > nums[right]) {
                swap(nums, --more, cur);
            } else {
                cur++;
            }
        }
        swap(nums, more, right);
        return new int[] { less + 1, more };
    }

    public  void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        Solution2 s = new Solution2();
        System.out.println(Arrays.toString(s.sortArray(nums)));
    }
}
