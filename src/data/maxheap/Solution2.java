package data.maxheap;

import data.arraystruct.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode面试题40——最小的k个数
 * @Date: 2020/3/20 7:07
 * @Email: 1031759184@qq.com
 */
public class Solution2 {
    private List<Integer> data;

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length < 1 || k < 1 || k > arr.length) {
            return new int[0];
        }
        data = new ArrayList<>();
        for (int value : arr) {
            data.add(value);
        }
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            heapify(i);
        }
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = extractMax();
        }
        return result;
    }

    private void heapify(int k) {
        while (leftChild(k) < data.size()) {
            int j = leftChild(k);
            if (j + 1 < data.size() && data.get(j + 1) < data.get(j)) {
                j = rightChild(k);
            }
            if (data.get(k) <= data.get(j)) {
                break;
            }
            data.set(k, data.get(k) ^ data.get(j));
            data.set(j, data.get(k) ^ data.get(j));
            data.set(k, data.get(k) ^ data.get(j));
            k = j;
        }
    }

    private int leftChild(int index) {
        return (index << 1) | 1;
    }

    private int rightChild(int index) {
        return (index << 1) | 2;
    }

    private int parent(int index) {
        return (index - 1) >> 1;
    }

    public int extractMax() {
        int result = data.get(0);
        data.set(0, data.get(0) ^ data.get(data.size() - 1));
        data.set(data.size() - 1, data.get(0) ^ data.get(data.size() - 1));
        data.set(0, data.get(0) ^ data.get(data.size() - 1));
        data.remove(data.size() - 1);
        heapify(0);
        return result;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int k = 8;
        Solution2 solution2 = new Solution2();
        System.out.println(Arrays.toString(solution2.getLeastNumbers(a, k)));
    }
}
