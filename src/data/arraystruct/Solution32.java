package data.arraystruct;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode1431——拥有糖果最多的孩子
 * @Date: 2020/6/1 8:13
 * @Email: 1031759184@qq.com
 */
public class Solution32 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCan = Integer.MIN_VALUE;
        for (int can : candies) {
            maxCan = Math.max(maxCan, can);
        }
        List<Boolean> res = new ArrayList<>();
        for (int can : candies) {
            res.add(can+extraCandies>=maxCan);
        }
        return res;
    }
}
