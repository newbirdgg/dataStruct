package data.redblacktree;

import data.binarysearchtreestruct.BinarySearchTree;
import data.map.BinarySearchTreeMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        int n = 2000000;
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0;i<n;i++){
            arrayList.add(random.nextInt(Integer.MAX_VALUE));
        }

        long startTime = System.nanoTime();
        BinarySearchTreeMap<Integer,Integer> binarySearchTreeMap = new BinarySearchTreeMap<>();
        for (Integer x:arrayList){
            binarySearchTreeMap.add(x,null);
        }
        long endtime = System.nanoTime();
        double time = (endtime-startTime)/1000000000.0;
        System.out.println(time);
        startTime = System.nanoTime();
        RedBlackTree<Integer,Integer> redBlackTree = new RedBlackTree<>();
        for (Integer x:arrayList){
            redBlackTree.add(x,null);
        }
        endtime = System.nanoTime();
        time = (endtime-startTime)/1000000000.0;
        System.out.println(time);
        
    }
}
