package data.maxheap;

import java.util.*;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第347题-前k个高频元素
 * @Date: 2020/3/5 15:35
 * @Email: 1031759184@qq.com
 */
public class Solution {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((Comparator.comparingInt(map::get)));
        for (int key:map.keySet()){
            if (pq.size()<k){
                pq.add(key);
            }else if (map.get(key)>map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()){
            res.add(pq.remove());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        System.out.println(topKFrequent(nums,k));
    }
}
