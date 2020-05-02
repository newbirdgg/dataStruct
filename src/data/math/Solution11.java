package data.math;

import data.map.Map;

import java.util.*;

/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第202题——快乐数
 *  @Date: 2020/4/30 7:55
 *  @Email: 1031759184@qq.com
 */
public class Solution11 {
    private HashMap<Integer,Integer> repeate;
    public boolean isHappy(int n) {
        repeate = new HashMap<>();
        return sum(n);
    }

    private boolean sum(int sumNum){
        if (sumNum == 1){
            return true;
        }
        if (null!=repeate.get(sumNum)) return false;
        repeate.put(sumNum,1);
        double sum = 0;
        while (sumNum>0){
            sum += Math.pow(sumNum%10,2);
            sumNum/=10;
        }
        return sum((int) sum);
    }

    public static void main(String[] args) {
        int a = 19;
        Solution11 s = new Solution11();
        s.isHappy(a);
    }
}
