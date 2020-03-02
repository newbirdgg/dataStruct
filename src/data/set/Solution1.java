package data.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第349题-两个数组的交集
 * @Date: 2020/3/1 20:42
 * @Email: 1031759184@qq.com
 */
public class Solution1 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                arrayList.add(num);
                set.remove(num);
            }
        }
        int[] res = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{2, 2};
        System.out.println(Arrays.toString(intersection(num1, num2)));
    }
}
