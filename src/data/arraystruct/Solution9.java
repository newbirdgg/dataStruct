package data.arraystruct;

import java.util.Arrays;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第5364题——按既定顺序创建目标数组
 * @Date: 2020/3/22 22:28
 * @Email: 1031759184@qq.com
 */
public class Solution9 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        boolean[] isInsert = new boolean[target.length];
        for (int i = 0; i < nums.length; i++) {
            if (!isInsert[index[i]]) {
                target[index[i]] = nums[i];
                isInsert[index[i]] = true;
            } else {
                int a = target.length;
                while (isInsert[--a]);
                target[a] = nums[i];
                while (a!=index[i]){
                    if (isInsert[a-1]){
                        isInsert[a] = true;
                    }
                    int t = target[a];
                    target[a] = target[a-1];
                    target[a-1] = t;
                    a--;
                }
            }
        }
        return target;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,4,3,2};
        int[] index = {0,0,1,3,1};
        Solution9 solution9 = new Solution9();
        System.out.println(Arrays.toString(solution9.createTargetArray(nums, index)));
    }
}
