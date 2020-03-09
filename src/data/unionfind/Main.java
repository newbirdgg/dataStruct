package data.unionfind;

import java.util.Random;

/**
 * @Author: liyuzhan
 * @classDesp： 并查集测试用例
 * @Date: 2020/3/9 9:15
 * @Email: 1031759184@qq.com
 */
public class Main {
    private static double testUF(UnionFindInterface unionFind, int m) {
        int size = unionFind.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.isConnected(a,b);
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 10000000;
        int m  = 10000000;
//        UnionFind1 unionFind1 = new UnionFind1(size);
//        System.out.println("UnionFind1 :"+testUF(unionFind1,m)+"s");
//        UnionFind2 unionFind2 = new UnionFind2(size);
//        System.out.println("UnionFind2 :"+testUF(unionFind2,m)+" s");
        UnionFind3 unionFind3 = new UnionFind3(size);
        System.out.println("UnionFind3 :"+testUF(unionFind3,m)+" s");
        UnionFind4 unionFind4 = new UnionFind4(size);
        System.out.println("UnionFind4 :"+testUF(unionFind4,m)+" s");
        UnionFind5 unionFind5 = new UnionFind5(size);
        System.out.println("UnionFind5 :"+testUF(unionFind5,m)+" s");
        UnionFind6 unionFind6 = new UnionFind6(size);
        System.out.println("UnionFind6 :"+testUF(unionFind6,m)+" s");

    }
}
