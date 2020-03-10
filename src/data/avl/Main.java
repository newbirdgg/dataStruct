package data.avl;

/**
 * @Author: liyuzhan
 * @classDesp： AVL测试类
 * @Date: 2020/3/10 15:00
 * @Email: 1031759184@qq.com
 */
public class Main {
    private static double testTime(AVLTree<Integer, Integer> tree, int count) {
        double startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            if (tree.contain(i)) {
                tree.set(i, tree.get(i) + 1);
            }
        }
        double endTime = System.nanoTime();
        System.out.println(tree.isBalanced());
        tree.remove(count/2);
        System.out.println(tree.isBalanced());
        tree.remove(count/3);
        System.out.println(tree.isBalanced());
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        AVLTree<Integer, Integer> avlTree = new AVLTree<>();
        int count = 20000;
        for (int i = 1; i < count; i++) {
            avlTree.add(i, i);

        }
        System.out.println(testTime(avlTree, count));


    }
}
