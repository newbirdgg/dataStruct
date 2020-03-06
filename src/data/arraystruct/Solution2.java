package data.arraystruct;

import java.util.*;

public class Solution2 {
    public static int[][] findContinuousSequence(int target) {
        int a=1;
        int b,k,z;
        List<int[]> list = new ArrayList<>();
        while (a < target) {
            z = a;b = a;k = 1;
            while (b < target) {
                z++;k++;
                b += z;
            }
            if (b == target) {
                z=a;
                int[] res = new int[k];
                for (int c = 0; c < k; c++) {
                    res[c] = z;
                    z++;
                }
                list.add(res);
            }
            a++;

        }
        int[][] result = new int[list.size()][];
        return list.toArray(result);
    }

    public static void main(String[] args) {
        int t = 150;
        System.out.println(Arrays.deepToString(findContinuousSequence(t)));
    }
}
