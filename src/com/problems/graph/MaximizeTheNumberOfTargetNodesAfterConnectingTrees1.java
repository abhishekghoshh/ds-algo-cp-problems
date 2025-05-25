package com.problems.graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem link :
 * https://leetcode.com/contest/weekly-contest-426/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/
 *
 * Solution link :
 *
 *
 */
public class MaximizeTheNumberOfTargetNodesAfterConnectingTrees1 {
    public static void main(String[] args) {
        type1();
        type2();
    }

    private static void type2() {
    }

    // our work is to find
    // 1. the node count with distance <= k for every node
    // 2. node with the max node count with the distance <= (k-1) as we have to add another edge from tree1 to tree2
    // we will add the results
    public int[] maxTargetNodes2(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1, m = edges2.length + 1;
        List<Integer>[] graph1 = graph(edges1), graph2 = graph(edges2);
        int[] ans = new int[n];
        int[] count1 = new int[n], count2 = new int[m];
        boolean[] visited1 = new boolean[n], visited2 = new boolean[m];
        // find in the tree 1
        // find in the tree 2
        return ans;
    }

    static List<Integer>[] graph(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            int start = e[0];
            int end = e[1];
            graph[start].add(end);
            graph[end].add(start);
        }
        return graph;
    }

    private static void type1() {
    }
}
