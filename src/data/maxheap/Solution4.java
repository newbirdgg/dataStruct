package data.maxheap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 *  @Author: liyuzhan
 *  @classDesp： 罗志祥多人运动
 *  @Date: 2020/4/27 16:41
 *  @Email: 1031759184@qq.com
 */
public class Solution4 {
    public int luoZhiXiangPaPaPa(List<int[]> list){
        PriorityQueue<int[]> heap = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
        for (int i = 0;i<list.size();i++){
            if (!heap.isEmpty()&&heap.peek()[1]<=list.get(i)[1]){
                heap.poll();
            }
            heap.add(list.get(i));
        }
        return heap.size();
    }

}
