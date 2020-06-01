package data.arraystruct;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第974题——和可被k整除的子数组
 * @Date: 2020/5/27 8:02
 * @Email: 1031759184@qq.com
 */
public class Solution30{
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum = 0;
        for (int value : A) {
            value = value < 0 ? (K - Math.abs(value) % K) : value;
            sum += value;
            int curNum = sum % K;
            if (map.containsKey(curNum)) count += map.get(curNum);
            map.put(curNum, map.getOrDefault(curNum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {4,5,0,-2,-3,1};
        Solution30 s = new Solution30();
        s.subarraysDivByK(a,5);
    }
}
