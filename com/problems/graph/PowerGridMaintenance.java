package com.problems.graph;

import com.util.PrintUtl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/*
 * Problem link:
 * https://leetcode.com/problems/power-grid-maintenance/description/
 * Solution link:
 *
 */
public class PowerGridMaintenance {
    public static void main(String[] args) {
        type1();
        type2();
    }

    private static void type2() {
    }

    // Using union find to group the power stations then resolve the queries one by one
    // todo this is not the optimal solution, we can use a better approach
    private static void type1() {
        int c = 5;
        int[][] connections = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] queries = {{1, 3}, {2, 1}, {1, 1}, {2, 2}, {1, 2}};
        int[] ans = processQueries1(c, connections, queries);
        PrintUtl.print(ans);
    }

    public static int[] processQueries1(int c, int[][] connections, int[][] queries) {
        // creating union find structure
        int[] parent = new int[c + 1];
        int[] wt = new int[c + 1];
        for (int i = 1; i <= c; i++) parent[i] = i;
        Arrays.fill(wt, 1);
        buildUnionFind(connections, parent, wt);

        TreeSet<Integer>[] powerStations = new TreeSet[c + 1];
        for (int node = 1; node <= c; node++) {
            // redoing the union find to get the parent of the node, if the path compression is not done
            int parentNode = parent[node] = parent(parent, node);
            if (powerStations[parentNode] == null) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(parentNode);
                powerStations[parentNode] = set;
            }
            powerStations[parentNode].add(node);
        }
        // even if the node is removed, we will still need to find the parent node, we will keep a copy of the parent array
        int[] copyParent = Arrays.copyOf(parent, parent.length);
        List<Integer> ans = new ArrayList<>();
        // Process each query
        for (int[] query : queries) {
            int op = query[0], node = query[1];
            int parentNode = parent[node];
            if (op == 1) {
                // copyParent[node] != -1 means it is not removed yet, so the ans will be the same node
                if (copyParent[node] != -1) {
                    ans.add(node);
                } else {
                    // the node is removed, we need to find the parent node
                    TreeSet<Integer> set = powerStations[parentNode];
                    int queryAns = !set.isEmpty() ? set.first() : -1;
                    ans.add(queryAns);
                }
            } else {
                // we will remove the node from the power station and update the copyParent
                powerStations[parentNode].remove(node);
                copyParent[node] = -1;
            }
        }
        // Convert the list to an array
        return convertListToArray(ans);
    }

    private static void buildUnionFind(int[][] connections, int[] parent, int[] wt) {
        for (int[] edge : connections) {
            int x = edge[0], y = edge[1];
            int root1 = parent(parent, x);
            int root2 = parent(parent, y);
            if (root1 == root2) continue;
            if (wt[root1] >= wt[root2]) {
                wt[root1] += wt[root2];
                wt[root2] = 0;
                parent[root2] = root1;
            } else {
                wt[root2] += wt[root1];
                wt[root1] = 0;
                parent[root1] = root2;
            }
        }
    }

    private static int[] convertListToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    static int parent(int[] par, int node) {
        int pt = node;
        while (pt != par[pt]) {
            pt = par[pt];
        }
        int root = pt;
        pt = node;
        while (pt != par[pt]) {
            int nextPt = par[pt];
            par[pt] = root;
            pt = nextPt;
        }
        return root;
    }
}