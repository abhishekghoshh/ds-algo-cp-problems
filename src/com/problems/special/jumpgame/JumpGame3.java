package com.problems.special.jumpgame;


import java.util.LinkedList;
import java.util.Queue;

/*
 *
 * problem links :
 * https://leetcode.com/problems/jump-game-iii/
 *
 * Solution link :
 * https://www.youtube.com/watch?v=7Cz91Uj0VCU&list=PLJtzaiEpVo2yaP5v5bq0-QJgU0lO3TrEi&index=3
 *
 * */
public class JumpGame3 {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
    }

    // we can do some optimizations on the bfs solution
    // we can check all the nodes in the same level of queue at a time
    // we can negate the point just to say that it is visited
    private static void type4() {
    }


    // todo it is not fast as the dfs
    // using BFS with Queue
    // but this is quite slow as we are using queue
    // recursion is faster than this
    private static void type3() {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        boolean ans = canReach3(arr, start);
        System.out.println(ans);
    }

    public static boolean canReach3(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (arr[curr] == 0) return true;
            int left = curr - arr[curr], right = curr + arr[curr];

            if (isNotVisited(left, visited, n)) {
                visited[left] = true;
                queue.add(left);
            }

            if (isNotVisited(right, visited, n)) {
                visited[right] = true;
                queue.add(right);
            }
        }
        return false;
    }

    private static boolean isNotVisited(int i, boolean[] visited, int n) {
        return i >= 0 && i < n && !visited[i];
    }

    // same as type 1 recursion
    // we are not using any extra visited array to mark
    // we are just multiplying the array item with -1 if we visit that
    private static void type2() {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        boolean ans = canReach2(arr, start);
        System.out.println(ans);
    }

    public static boolean canReach2(int[] arr, int start) {
        // If the start is out of bounds or the value at start is negative, return false
        if (start < 0 || start >= arr.length || arr[start] < 0) return false;
        // If the value at start is 0, we have reached our goal
        if (arr[start] == 0) return true;
        // Mark the current position as visited by making the value negative
        int jump = arr[start];
        arr[start] = -arr[start];
        // Try jumping left and right recursively
        if (canReach2(arr, start + jump)
                || canReach2(arr, start - jump))
            return true;
        // If we can't reach the goal from this position, revert the change
        arr[start] = -arr[start];
        return false;
    }

    // using recursion
    private static void type1() {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        boolean ans = canReach1(arr, start);
        System.out.println(ans);
    }

    public static boolean canReach1(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        return canReach1(arr, start, visited, n);
    }

    private static boolean canReach1(int[] arr, int start, boolean[] visited, int n) {
        if (start < 0 || start >= n) return false;
        if (arr[start] == 0) return true;
        if (visited[start]) return false;
        visited[start] = true;
        int left = start - arr[start], right = start + arr[start];
        return canReach1(arr, left, visited, n)
                || canReach1(arr, right, visited, n);
    }
}
