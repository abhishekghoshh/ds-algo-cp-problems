package com.problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem link :
 * https://leetcode.com/problems/properties-graph/description/
 *
 * Solution link:
 *
 *
 * */
public class PropertiesGraph {

    /**
     * Define a function intersect(a, b) that returns the number of distinct integers common to both arrays a and b.
     * <p>
     * Construct an undirected graph where each index i corresponds to properties[i].
     * There is an edge between node i and node j if and only if intersect(properties[i], properties[j]) >= k,
     * where i and j are in the range [0, n - 1] and i != j.
     */
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // todo check other submissions also
    // using bit-set/boolean array instead of array
    private static void type3() {
        int[][] properties = {{1, 2}, {1, 1}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        int k = 1;
        int ans = numberOfComponents3(properties, k);
        System.out.println(ans);
    }

    private static int numberOfComponents3(int[][] properties, int k) {
        int n = properties.length;
        // converting properties array to bitset array
        boolean[][] rows = new boolean[n][101];
        for (int i = 0; i < n; i++) {
            int[] row = properties[i];
            for (int item : row) rows[i][item] = true;
        }

        int com = 0;

        int[] parent = new int[n];
        int[] rank = new int[n];
        // now we will initialize parent and rank
        for (int i = 0; i < n; i++) parent[i] = i;
        Arrays.fill(rank, 1);

        // now we will check for all the nodes
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // i and j already in the same component, like (2,3) and (2,4) is already calculated then 3,4 is not necessary
                if (parent(i, parent) == parent(j, parent)) continue;
                // now we will check for intersect
                if (intersect3(rows[i], rows[j], k)) {
                    union1(i, j, parent, rank);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == parent[i]) com++;
        }
        return com;
    }

    private static boolean intersect3(boolean[] set1, boolean[] set2, int k) {
        int c = 0;
        for (int i = 1; i <= 100; i++) {
            if (set1[i] && set2[i]) c++;
            if (c >= k) return true;
        }
        return false;
    }

    // we can apply little optimization here
    // instead of creating an adjacency list and then saving to that we can directly apply union find and group the components
    // by this we have reduced our time and space complexity
    // then at last we will return the number of component
    private static void type2() {
        int[][] properties = {{1, 2}, {1, 1}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        int k = 1;
        int ans = numberOfComponents2(properties, k);
        System.out.println(ans);
    }

    private static int numberOfComponents2(int[][] properties, int k) {
        int n = properties.length;
        int com = 0;

        int[] parent = new int[n];
        int[] rank = new int[n];
        // now we will initialize parent and rank
        for (int i = 0; i < n; i++) parent[i] = i;
        Arrays.fill(rank, 1);

        // now we will check for all the nodes
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersect1(properties[i], properties[j], k)) {
                    union1(i, j, parent, rank);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == parent[i]) com++;
        }
        return com;
    }

    private static void union1(int i, int j, int[] parent, int[] rank) {
        int rootI = parent(i, parent);
        int rootJ = parent(j, parent);
        if (rootI == rootJ) return;

        // point-I will be the parent of point=J
        if (rank[rootI] >= rank[rootJ]) {
            rank[rootI] += rank[rootJ];
            rank[rootJ] = 0;
            parent[rootJ] = rootI;
        } else {
            rank[rootJ] += rank[rootI];
            rank[rootI] = rootJ;
            parent[rootI] = rootJ;
        }
    }

    private static int parent(int j, int[] parent) {
        int p = -1;
        int src = j;
        // finding the parent iteratively
        while (src != parent[src]) {
            src = parent[src];
        }
        p = src;
        src = j;
        // path compression
        while (src != parent[src]) {
            src = parent[src];
            parent[src] = p;
        }
        return p;
    }

    // todo simplest approach
    // first we will create the graph then we will use dfs to find
    private static void type1() {
        int[][] properties = {{1, 2}, {1, 1}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        int k = 1;
        int ans = numberOfComponents1(properties, k);
        System.out.println(ans);
    }

    public static int numberOfComponents1(int[][] properties, int k) {
        int n = properties.length;
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();
        //  we are create the adjacency list first
        // one optimization here we are going i from 0..n-1 and j from i+1..n-1
        // so that if 1-3 is computed then it should not compute 3-1 again
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersect1(properties[i], properties[j], k)) {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }
        // then using a visited array we are creating the components
        boolean[] vis = new boolean[n];
        int com = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs1(i, vis, adjList);
                com++;
            }
        }
        return com;
    }

    private static void dfs1(int src, boolean[] vis, List<Integer>[] adjList) {
        vis[src] = true;
        for (int des : adjList[src]) {
            if (!vis[des]) dfs1(des, vis, adjList);
        }
    }

    public static boolean intersect1(int[] arr1, int[] arr2, int k) {
        int[] set = new int[101];
        int c = 0;
        for (int num : arr1) set[num] = 1;
        for (int num : arr2) {
            if (set[num] == 1)
                set[num] = 2;
        }
        for (int num : set) {
            if (num == 2) c++;
            if (c >= k) return true;
        }
        return false;
    }
}
