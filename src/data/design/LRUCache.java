package data.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第146题——LRU缓存机制
 * @Date: 2020/5/25 7:53
 * @Email: 1031759184@qq.com
 */
public class LRUCache {
    HashMap<Integer,Node> cacheHashMap;
    private Node tail,head;
    int capacity;
    int size;
    public LRUCache(int capacity) {
        cacheHashMap = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        Node node = cacheHashMap.get(key);
        if (null==node) return -1;
        remove(node);
        addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cacheHashMap.get(key);
        if (null!=node){
            node.value = value;
            remove(node);
            addFirst(node);
        }else {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            addFirst(newNode);
            ++size;
            cacheHashMap.put(key,newNode);
            if (size>capacity){
                Node useLess = tail.pre;
                remove(tail.pre);
                cacheHashMap.remove(useLess.key);
                --size;
            }
        }
    }

    private void addFirst(Node node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    private void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    static class Node{
        int key,value;
        Node pre,next;
    }

    public static void main(String[] args) {
        LRUCache lruCache  = new LRUCache(2);
        lruCache.put(1,1);
    }
}
