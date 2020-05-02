package data.arraystruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode面试题51.数组中的逆序对
 * @Date: 2020/4/24 8:08
 * @Email: 1031759184@qq.com
 */
public class Solution21 {
    private int result;

    public int reversePairs(int[] nums) {
        if (nums.length==0)return 0;
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
        compare(l, r, mid, arr);
    }

    public void compare(int l, int r, int mid, int[] arr) {
        int[] newArr = new int[r - l + 1];
        int p = 0;
        int leftPoint = l;
        int rightPoint = mid + 1;
        int count = 0;
        while (leftPoint <= mid && rightPoint <= r) {
            if (arr[leftPoint] <= arr[rightPoint]){
                newArr[p++] = arr[leftPoint++];
                result+=count;
            }else {
                newArr[p++]=arr[rightPoint++];
                count++;
            }
        }

        while (leftPoint <= mid) {
            newArr[p++] = arr[leftPoint++];
            result+=count;
        }
        while (rightPoint <= r) {
            newArr[p++] = arr[rightPoint++];
        }
        if (newArr.length >= 0) {
            System.arraycopy(newArr, 0, arr, l, newArr.length);
        }
    }

    public static void main(String[] args) {
        int[] num = {7,5,6,4};
        Solution21 s = new Solution21();
        s.reversePairs(num);
    }
}
