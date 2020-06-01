package data.arraystruct;

import java.util.*;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第53题——最大子序和
 * @Date: 2020/5/3 8:24
 * @Email: 1031759184@qq.com
 */
public class Solution24 {
    private int result = Integer.MIN_VALUE;

    public int maxSubArray(int[] nums) {
        if (nums.length==0)return 0;
        if (nums.length==1)return nums[0];
        process(0, nums.length - 1, nums);
        return result;
    }

    private void process(int l, int r, int[] arr) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(l, mid, arr);
        process(mid + 1, r, arr);
        result = Math.max(result,merge(l, r, mid, arr));
    }

    private int merge(int l, int r, int mid, int[] arr) {

        int leftSum = 0;
        int rightSum = 0;
        for (int i = l; i <= mid; i++) {
            leftSum += arr[i];
        }
        for (int j = mid + 1; j <= r; j++) {
            rightSum += arr[j];
        }
        int max = Math.max(Math.max(leftSum, rightSum), leftSum + rightSum);

        int leftSubArrMax = Integer.MIN_VALUE;
        int rightSubArrMax = arr[mid+1];
        int leftSubArr = 0;
        int rightSubArr = 0;
        for (int i = mid;i>=l;i--){
            leftSubArr+=arr[i];
            leftSubArrMax = Math.max(leftSubArrMax,leftSubArr);
        }
        for (int i = mid+1;i<=r;i++){
            rightSubArr+=arr[i];
            rightSubArrMax = Math.max(rightSubArrMax,rightSubArr);
        }
        int subArrMax = rightSubArrMax + leftSubArrMax;
        return Math.max(subArrMax,max);
    }

    public static void main(String[] args) {
        int[] a = {-1,0,-2};
        Solution24 s = new Solution24();
        s.maxSubArray(a);
    }
}
