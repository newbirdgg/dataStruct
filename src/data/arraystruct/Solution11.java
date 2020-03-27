package data.arraystruct;

import java.util.HashMap;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第914题——卡牌分组
 * @Date: 2020/3/27 7:07
 * @Email: 1031759184@qq.com
 */
public class Solution11 {
    private int count = Integer.MAX_VALUE;

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1) {
            return false;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        final boolean[] result = {true};
        for (int i : deck) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, 1);
            } else {
                hashMap.put(i, hashMap.get(i) + 1);
            }
        }

        hashMap.forEach(
                (k, v) -> {
                    if (count == Integer.MAX_VALUE) {
                        count = v;
                    }
                    int max = Math.max(v, count);
                    int min = Math.min(v, count);
                    if (min%gcd(max,min)!=0||gcd(max,min)==1) {
                        result[0] = false;
                    }
                    count = max;
                }
        );
        return result[0];
    }

    private int gcd(int a, int b) {
        if(a%b==0) {
            return b;
        } else {
            return gcd(b,a%b);
        }
    }
}
