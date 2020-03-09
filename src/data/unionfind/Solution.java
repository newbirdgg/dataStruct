package data.unionfind;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: liyuzhan
 * @classDesp： 使用并查集解决LeetCode200题-岛屿数量
 * @Date: 2020/3/9 11:19
 * @Email: 1031759184@qq.com
 */
public class Solution {
    static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public boolean isConnect(int a, int b) {
            return find(a) == find(b);
        }

        public void unionElement(int a, int b) {
            int aRoot = find(a), bRoot = find(b);
            if (aRoot == bRoot) {
                return;
            }
            if (rank[aRoot] > rank[bRoot]) {
                parent[bRoot] = aRoot;
            } else if (rank[bRoot] > rank[aRoot]) {
                parent[aRoot] = bRoot;
            } else {
                parent[aRoot] = bRoot;
                rank[bRoot]++;
            }
        }

        public int find(int a) {
            while (a != parent[a]) {
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return parent[a];
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int rows = grid.length, cols = grid[0].length;
        UnionFind unionFind = new UnionFind(rows * cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i - 1][j] == '1') {
                        unionFind.unionElement(i * cols + j, (i - 1) * cols + j);
                    }
                    if (i < rows - 1 && grid[i + 1][j] == '1') {
                        unionFind.unionElement(i * cols + j, (i + 1) * cols + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        unionFind.unionElement(i * cols + j, i * cols + j - 1);
                    }
                    if (j < cols - 1 && grid[i][j + 1] == '1') {
                        unionFind.unionElement(i * cols + j, i * cols + j + 1);
                    }
                }
                set.add(unionFind.find(i * cols + j));
            }
        }

        return set.size();
    }
}
