package data.sort;

import java.util.Arrays;

/**
 * @Author: liyuzhan
 * @classDesp： 归并排序
 * @Date: 2020/3/20 20:52
 * @Email: 1031759184@qq.com
 */
public class MergeSort {
    public void mergeSort(int[] arr) {
        process(0, arr.length - 1, arr);
    }

    private void process(int l, int r, int[] arr) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(l, mid, arr);
        process(mid + 1, r, arr);
        merge(l, r, mid, arr);
    }

    public void merge(int l, int r, int mid, int[] arr) {
        int[] newArr = new int[r - l + 1];
        int p = 0;
        int leftPoint = l;
        int rightPoint = mid + 1;
        while (leftPoint <= mid && rightPoint <= r) {
            newArr[p++] = arr[leftPoint] <= arr[rightPoint] ? arr[leftPoint++] : arr[rightPoint++];
        }
        while (leftPoint <= mid) {
            newArr[p++] = arr[leftPoint++];
        }
        while (rightPoint <= r) {
            newArr[p++] = arr[rightPoint++];
        }
        if (newArr.length >= 0) {
            System.arraycopy(newArr, 0, arr, l, newArr.length);
        }
    }

    public static void main(String[] args) {
        int[] i = {5, 3, 6, 7, 11, 53, 2, 1, 9};
        System.out.println(Arrays.toString(i));
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(i);
        System.out.println(Arrays.toString(i));
    }

}
