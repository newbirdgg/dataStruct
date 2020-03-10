package data.set;

import data.avl.AVLTree;

/**
 * @Author: liyuzhan
 * @classDesp： 基于AVL树的集合
 * @Date: 2020/3/10 16:23
 * @Email: 1031759184@qq.com
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {
    private AVLTree<E, Object> avl;

    public AVLSet() {
        avl = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        avl.add(e, null);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avl.contain(e);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }


}
