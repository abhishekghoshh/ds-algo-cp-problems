package com.util;

import com.algo.binarytree.TNode;
import com.algo.linkedlist.DNode;
import com.algo.linkedlist.Node;

import java.util.ArrayList;
import java.util.List;

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
}
