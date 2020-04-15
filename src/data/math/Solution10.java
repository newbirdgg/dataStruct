package data.math;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode面试题 16.03.交点 (放弃)
 * @Date: 2020/4/12 7:24
 * @Email: 1031759184@qq.com
 */
public class Solution10 {
    private double[] result = new double[2];

    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        //判断点start2、end2是否在线段start1->end1两边
        boolean isIntersect =
                (cross(start1, end1, start2) < 0 && (cross(start1, end1, end2) >= 0))
                        || (cross(start1, end1, start2) > 0 && (cross(start1, end1, end2) <= 0))
                        || (cross(start1, end1, start2) <= 0 && (cross(start1, end1, end2) > 0))
                        || (cross(start1, end1, start2) >= 0 && (cross(start1, end1, end2) < 0));
        if (isIntersect) {

        }
        //共线
        if (cross(start1, end1, start2) == 0 && cross(start1, end1, end2) == 0) {
            if (isIn(start1, end1, start2) && isIn(start1, end1, end2)) {

            }
        }
        return new double[]{};
    }

    /**
     * 叉乘
     *
     * @param a 线段ab的点a
     * @param b 线段ab的点b
     * @param x 另一条线段的其中一个点x
     * @return 叉乘值
     */
    private int cross(int[] a, int[] b, int[] x) {
        int[] ab = {b[0] - a[0], b[1] - a[1]};
        int[] ax = {x[0] - a[0], x[1] - a[1]};
        return ab[0] * ax[1] - ax[0] * ab[1];
    }

    /**
     * 判断共线是否相交
     *
     * @param start1 线段start1->start2的点
     * @param end1   线段start1->start2的点
     * @param point  被判断的点point
     * @return point是否在start1->start2上
     */
    private boolean isIn(int[] start1, int[] end1, int[] point) {
        return (Math.min(start1[0], end1[0]) <= point[0] && Math.max(start1[0], end1[0]) >= point[0])
                && (Math.min(start1[1], end1[1]) <= point[1] && Math.max(start1[1], end1[1]) >= point[1]);
    }

}
