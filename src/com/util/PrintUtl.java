package com.util;

import com.algo.binarytree.TNode;
import com.algo.linkedlist.DNode;
import com.algo.linkedlist.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintUtl {
    public static void printException(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void print2D(int[][] matrix) {
        for (int[] row : matrix) {
            for (int item : row) System.out.print(item + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void print(List<Integer> arr) {
        for (int item : arr) System.out.print(item + " ");
        System.out.println();
    }
    public static void print(String... arr) {
        for (String item : arr) System.out.print(item + " ");
        System.out.println();
    }

    public static void print2D(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (Integer item : row) System.out.print(item + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void print(int[] arr) {
        if (arr != null) for (int item : arr) System.out.print(item + " ");
        System.out.println();
    }

    public static void print(long[] arr) {
        if (arr != null) for (long item : arr) System.out.print(item + " ");
        System.out.println();
    }
    @SafeVarargs
    public static void print(List<Integer>... arrays) {
        for (List<Integer> array : arrays) {
            for (int num : array) System.out.print(num + " ");
            System.out.println();
        }
        System.out.println();
    }
    public static void print(int[]... arrays) {
        for (int[] array : arrays) {
            for (int num : array) System.out.print(num + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void print(char[] arr) {
        for (char item : arr) System.out.print(item + " ");
        System.out.println();
    }

    public static void print(Node node) {
        while (null != node) {
            System.out.print(node.data);
            printRandom(node);
            printBottom(node);
            node = node.next;
            if (node != null) System.out.print(", ");
        }
        System.out.println();
    }

    public static void printRandom(Node node) {
        if (node.random == null) return;
        System.out.print(" -> [" + node.random.data + "]");
    }

    public static void printBottom(Node node) {
        if (node.bottom == null) return;
        Node bottom = node.bottom;
        System.out.print(" -> [");
        while (bottom != null) {
            System.out.print(bottom.data);
            if (bottom.bottom != null) System.out.print(", ");
            bottom = bottom.bottom;
        }
        System.out.print("]");
    }

    public static void print(DNode node) {
        while (null != node) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void print(TNode root) {
        if (root == null) return;
        List<List<TNode>> level = buildLevelWiseNodes(root);
        for (List<TNode> tNodes : level) {
            for (TNode node : tNodes) {
                System.out.printf("[%d : ", node.data);
                String left = null == node.left ? "null" : node.left.data + "";
                System.out.printf("left -> %s, ", left);
                String right = null == node.right ? "null" : node.right.data + "";
                System.out.printf("right -> %s", right);
                System.out.print("]");
                System.out.println();
            }
        }
    }

    public static void printWithDetail(TNode root) {
        if (root == null) return;
        List<List<TNode>> level = buildLevelWiseNodes(root);
        for (int i = 0; i < level.size(); i++) {
            for (TNode node : level.get(i)) {
                System.out.printf("[level(%d) node(%d) hashCode(%d): ", i, node.data, node.hashCode());
                String left = null == node.left ? "null" : "node(" + node.left.data + ") hashCode(" + node.left.hashCode() + ")";
                System.out.printf("left -> %s, ", left);
                String right = null == node.right ? "null" : "node(" + node.right.data + ") hashCode(" + node.right.hashCode() + ")";
                System.out.printf("right -> %s", right);
                System.out.print("]");
                System.out.println();
            }
        }
    }

    private static List<List<TNode>> buildLevelWiseNodes(TNode root) {
        List<List<TNode>> level = new ArrayList<>();
        level.add(List.of(root));
        while (true) {
            List<TNode> nodes = level.get(level.size() - 1);
            List<TNode> newNodes = new ArrayList<>();
            for (TNode node : nodes) {
                if (node.left != null) newNodes.add(node.left);
                if (node.right != null) newNodes.add(node.right);
            }
            if (newNodes.isEmpty()) break;
            level.add(newNodes);
        }
        return level;
    }


    public static void inOrder(TNode root) {
        System.out.println(inOrder(root, new ArrayList<>()));
    }


    public static List<Integer> inOrder(TNode root, List<Integer> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.add(root.data);
            inOrder(root.right, list);
        }
        return list;
    }

    public static void preOrder(TNode root) {
        System.out.println(preOrder(root, new ArrayList<>()));
    }

    public static List<Integer> preOrder(TNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.data);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
        return list;
    }

    public static void postOrder(TNode root) {
        System.out.println(postOrder(root, new ArrayList<>()));
    }

    public static List<Integer> postOrder(TNode root, List<Integer> list) {
        if (root != null) {
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.data);
        }
        return list;
    }

    public static void levelOrder(TNode root) {
        if (null == root) return;
        Queue<TNode> queue = new LinkedList<>();
        int l = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TNode parent = queue.poll();
                level.add(parent.data);
                if (parent.left != null) queue.offer(parent.left);
                if (parent.right != null) queue.offer(parent.right);
            }
            System.out.println("level -> " + (l++) + " -> " + level);
        }
    }
}
