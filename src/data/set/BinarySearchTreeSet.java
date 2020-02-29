package data.set;

import data.binarysearchtreestruct.BinarySearchTree;

/**
 *  @Author: liyuzhan
 *  @classDesp： 以二分搜索树为底层实现的集合
 *  @Date: 2020/2/29 19:23
 *  @Email: 1031759184@qq.com
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {
    private BinarySearchTree<E> binarySearchTree;
    public BinarySearchTreeSet(){
        binarySearchTree = new BinarySearchTree<>();
    }
    @Override
    public void add(E e) {
        binarySearchTree.add(e);
    }

    @Override
    public void remove(E e) {
        binarySearchTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return binarySearchTree.contains(e);
    }

    @Override
    public int getSize() {
        return binarySearchTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return binarySearchTree.isEmpty();
    }

}
