package data.math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第56题——合并区间
 * @Date: 2020/3/18 7:40
 * @Email: 1031759184@qq.com
 */
public class Solution2 {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < intervals.length; i++) {
            if (res.isEmpty() || res.getLast()[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            }
        }

        return res.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{2, 3}, {4, 5},{6,7},{1,10}};
        Solution2 s = new Solution2();
        System.out.println(Arrays.deepToString(s.merge(intervals)));
    }
}
