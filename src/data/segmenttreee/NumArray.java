package data.segmenttreee;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第303题-区域和检索，数组不可变
 * @Date: 2020/3/6 16:56
 * @Email: 1031759184@qq.com
 */
public class NumArray {
    private int[] segmentTree;
    private int[] data;

    public NumArray(int[] nums) {
        if (nums.length!=0){
            data = new int[nums.length];
            for (int i = 0;i<nums.length;i++){
                data[i] = nums[i];
            }
            segmentTree = new int[4 * nums.length];
            buildSegmentTree(0, 0, nums.length - 1);
        }else {
            data = new int[]{};
        }

    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            segmentTree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = 2 * treeIndex + 1;
        int rightTreeIndex = 2 * treeIndex + 2;
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        segmentTree[treeIndex] = segmentTree[leftTreeIndex] + segmentTree[rightTreeIndex];
    }

    private int query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return segmentTree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = 2 * treeIndex + 1;
        int rightTreeIndex = 2 * treeIndex + 2;

        if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        } else {
            int leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            int rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return leftResult + rightResult;
        }
    }

    public int sumRange(int i, int j) {
        if(data.length==0){
            return 0;
        }
        return query(0, 0, data.length-1, i, j);
    }

    public static void main(String[] args) {
        int[] nums = {-8261,2300,-1429,6274,9650,-3267,1414,-8102,6251,-5979,-5291,-4616,-4703};
        NumArray numArray = new NumArray(nums);
        int param_1 = numArray.sumRange(4, 5);
        int param_2 = numArray.sumRange(0, 8);
        int param_3 = numArray.sumRange(9, 11);
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);

    }
}
