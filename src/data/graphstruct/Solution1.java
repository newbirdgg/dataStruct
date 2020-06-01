package data.graphstruct;

import data.queuestruct.Queue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第210题——课程表 II
 * @Date: 2020/5/17 8:19
 * @Email: 1031759184@qq.com
 */
public class Solution1 {
    private LinkedList<Integer> queue;
    private int count;
    private int[] result;
    private HashMap<Integer, HashSet<Integer>> hashMap;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[0];
        queue = new LinkedList<>();
        result = new int[numCourses];
        hashMap = new HashMap<>();
        int[] degreeTable = new int[numCourses];
        for (int[] pre : prerequisites) {
            if (!hashMap.containsKey(pre[1])) {
                HashSet<Integer> hashSet = new HashSet<>();
                hashSet.add(pre[0]);
                hashMap.put(pre[1], hashSet);
            } else {
                hashMap.get(pre[1]).add(pre[0]);
            }
            ++degreeTable[pre[0]];
        }
        for (int i = 0; i < degreeTable.length; i++) {
            if (degreeTable[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int cur = queue.pop();
            result[count++] = cur;
            HashSet<Integer> hashSet = hashMap.get(cur);
            if (null != hashSet) {
                for (int num : hashSet) {
                    if (--degreeTable[num] == 0) queue.add(num);
                }
            }

        }
        return count == numCourses ? result : new int[0];
    }

    public static void main(String[] args) {
        int[][] a = {{1, 0}};
        int b = 2;
        Solution1 s = new Solution1();
        s.findOrder(b, a);
    }
}
