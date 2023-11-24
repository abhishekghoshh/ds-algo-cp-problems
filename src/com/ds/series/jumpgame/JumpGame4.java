package com.ds.series.jumpgame;


import java.util.*;

/*
 *
 * problem links :
 * https://leetcode.com/problems/jump-game-iv/
 *
 * Solution link :
 * https://www.youtube.com/watch?v=JYbU8RH1OSQ&list=PLJtzaiEpVo2yaP5v5bq0-QJgU0lO3TrEi&index=4
 *
 * */
public class JumpGame4 {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    static class IndexNode {
        final int index;
        final int steps;

        IndexNode next = null;

        IndexNode(int index, int steps) {
            this.index = index;
            this.steps = steps;
        }
    }

    // TODO understand and explore it
    private static void type3() {
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        int step = minJumps3(arr);
        System.out.println(step);
    }


    private static int minJumps3(int[] arr) {
        int length = arr.length;
        if (length == 1) {
            return 0;
        }
        if (length == 2 || arr[0] == arr[length - 1]) {
            return 1;
        }
        if (length == 3 || arr[0] == arr[length - 2] || arr[1] == arr[length - 1]) {
            return 2;
        }

        int end = length - 1;

        Map<Integer, List<Integer>> map = new HashMap<>(length, 1);
        map.put(arr[0], new LinkedList<>(Arrays.asList(0)));
        map.put(arr[end], new LinkedList<>(Arrays.asList(end)));
        for (int i = 1; i < end; i++) {
            if (arr[i] == arr[i - 1] && arr[i] == arr[i + 1]) {
                continue;
            }
            List<Integer> list = map.get(arr[i]);
            if (list == null) {
                list = new LinkedList<>();
                map.put(arr[i], list);
            }
            list.add(i);
        }

        boolean[] visited = new boolean[length];
        visited[0] = true;

        IndexNode node = new IndexNode(0, 0);
        IndexNode last = node;

        while (node != null) {
            int index = node.index;
            if (index == end) {
                return node.steps;
            }

            if (index > 0 && !visited[index - 1]) {
                visited[index - 1] = true;
                last.next = new IndexNode(index - 1, node.steps + 1);
                last = last.next;
            }
            if (index < end && !visited[index + 1]) {
                visited[index + 1] = true;
                last.next = new IndexNode(index + 1, node.steps + 1);
                last = last.next;
            }

            List<Integer> list = map.get(arr[index]);
            if (list != null) {
                for (int idx : list) {
                    if (!visited[idx]) {
                        visited[idx] = true;
                        last.next = new IndexNode(idx, node.steps + 1);
                        last = last.next;
                    }
                }
                map.remove(arr[index]);
            }

            node = node.next;
        }

        return length - 1;
    }


    // using bfs
    // use a queue and add nodes level wise
    // use linked list in place of normal array list
    private static void type2() {
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        int step = minJumps2(arr);
        System.out.println(step);
    }

    public static int minJumps2(int[] arr) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i], new LinkedList<>());
            map.get(arr[i]).offer(i);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n - 1) {
                    return step;
                }
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.add(curr - 1);
                }
                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.add(curr + 1);
                }
                LinkedList<Integer> list = map.get(arr[curr]);
                while (!list.isEmpty()) {
                    int idx = list.pollLast();
                    if (!visited[idx]) {
                        visited[idx] = true;
                        queue.add(idx);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    private static void type1() {
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        int step = minJumps1(arr);
        System.out.println(step);
    }

    private static int minJumps1(int[] arr) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i], new LinkedList<>());
            map.get(arr[i]).offer(i);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<int[]> queue = new LinkedList<>();
        int[] pair = {0, 0};
        queue.offer(pair);
        int curr, step = -1;
        while (!queue.isEmpty()) {
            pair = queue.poll();
            curr = pair[0];
            step = pair[1];
            if (curr == n - 1) {
                break;
            }
            if (curr - 1 >= 0 && !visited[curr - 1]) {
                visited[curr - 1] = true;
                queue.add(new int[]{curr - 1, step + 1});
            }
            if (curr + 1 < n && !visited[curr + 1]) {
                visited[curr + 1] = true;
                queue.add(new int[]{curr + 1, step + 1});
            }
            LinkedList<Integer> list = map.get(arr[curr]);
            while (!list.isEmpty()) {
                int idx = list.pollLast();
                if (!visited[idx]) {
                    visited[idx] = true;
                    queue.add(new int[]{idx, step + 1});
                }
            }
        }
        return step;
    }

}
