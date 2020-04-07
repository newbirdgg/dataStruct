package data.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第72题——编辑距离(备忘录优化版)
 * @Date: 2020/4/6 8:17
 * @Email: 1031759184@qq.com
 */
public class Solution6 {
    private char[] chars1, chars2;

    public int minDistance(String word1, String word2) {
        chars1 = word1.toCharArray();
        chars2 = word2.toCharArray();
        Map<String, Integer> hashMap = new HashMap<>();
        return minDistance(chars1.length - 1, chars2.length - 1, hashMap);
    }

    private int minDistance(int i, int j, Map<String, Integer> hashMap) {
        if (i == -1) {
            return j+1;
        }
        if (j == -1) {
            return i+1;
        }
        String index = i+""+j;
        if (hashMap.containsKey(index)){
            return hashMap.get(index);
        }
        if (chars1[i] == chars2[j]) {
            int eq = minDistance(i - 1, j - 1, hashMap);
            hashMap.put(index,eq) ;
        } else {
            int insert = minDistance(i, j - 1,hashMap) + 1;
            int delete = minDistance(i - 1, j,hashMap) + 1;
            int update = minDistance(i - 1, j - 1,hashMap) + 1;
            hashMap.put(index,Math.min(insert,Math.min(delete,update))) ;
        }
        return hashMap.get(index);
    }

    public static void main(String[] args) {
//        String a = "intention";
//        String b = "execution";

        String a = "dinitrophenylhydrazinedsaddwqrdsaczxcarqr2qrasdasdasdqedasc";
        String b = "benzalphenylhydrazonedasdasdqqwdasdqwereqwdasdeqweqedffdgfgcr";
        int a1 =1,b1=2;

        Solution6 solution6 = new Solution6();
        System.out.println(solution6.minDistance(a, b));


    }
}
