package data.math;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: liyuzhan
 * @classDesp： 约瑟夫环
 * @Date: 2020/3/19 22:32
 * @Email: 1031759184@qq.com
 */
public class Solution5 {
    private int ring(int[] arr) {
        List<Integer> list = new LinkedList<>();
        for (int i:arr){
            list.add(i);
        }
        int index = 1;
        int count = 0;
        while (list.size()>1){
            if ((index%3)==0&&index>2){
                list.remove(count);
                count--;
            }
            count = count==list.size()-1?0:++count;
            index++;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.ring(a));
    }
}
