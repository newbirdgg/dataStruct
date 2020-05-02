package data.recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第46题——全排列
 * @Date: 2020/4/25 8:12
 * @Email: 1031759184@qq.com
 */
public class Solution3 {
    private List<List<Integer>> resultList;
    private List<Integer> list;
    private boolean[] isMark;

    public List<List<Integer>> permute(int[] nums) {
        resultList = new LinkedList<>();
        if (nums.length == 0) return resultList;
        for (int i = 0; i < nums.length; i++) {
            swap(i, nums, 0);
            list = new LinkedList<>();
            recursive(nums[0], nums, 1);
        }
        return resultList;
    }

    private void recursive(int num, int[] nums, int index) {
        list.add(num);
        for (int i = index; i < nums.length; i++) {
            swap(i, nums, index);
            recursive(nums[index], nums, index + 1);
            swap(i, nums, index);
            list.remove(list.size() - 1);
        }
        if (list.size() == nums.length) {
            resultList.add(new LinkedList<>(list));
        }
    }

    private void swap(int i, int[] nums, int index) {
        int t = nums[i];
        nums[i] = nums[index];
        nums[index] = t;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        Solution3 s = new Solution3();
        s.permute(a);
    }
}
