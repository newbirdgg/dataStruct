package data.segmenttreee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: liyuzhan
 * @classDesp： 线段树测试类
 * @Date: 2020/3/6 15:28
 * @Email: 1031759184@qq.com
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        List<int[]> list = new ArrayList<>();
        for (int i = 0;i<nums.length;i++){
            for (int j = i;j<nums.length;j++){
                if (segmentTree.query(i,j)==9&&i!=j){
                    int[] res = new int[j-i+1];
                    for (int c = i,a=0;c<=j;c++,a++){
                        res[a] = c+1;
                    }
                    list.add(res);
                }
            }
        }
        int[][] result = new int[list.size()][];
        System.out.println(Arrays.deepToString(list.toArray(result)));
    }
}
