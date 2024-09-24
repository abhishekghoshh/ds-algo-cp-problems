package com.problems.binarytree;

import com.ds.binarytree.TNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Problem link :
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 * https://www.geeksforgeeks.org/problems/maximum-width-of-tree/1
 * https://www.naukri.com/code360/problems/maximum-width-in-binary-tree_763671
 *
 * Solution link :
 * https://www.youtube.com/watch?v=ZbybYvcVLks&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=29
 *
 * https://takeuforward.org/data-structure/maximum-width-of-a-binary-tree/
 */
public class MaximumWidthOfBinaryTree {

    public static void main(String[] args) {
        type1();
        type2();
    }

    // recursive way
    private static void type2() {
        TNode root = TNode.withCount(15);
        int width = widthOfBinaryTree(root);
        System.out.println(width);
    }

    public static int widthOfBinaryTree(TNode root) {
        if (root == null) return 0;
        return dfs(root, 0, 1, new ArrayList<>());
    }

    private static int dfs(TNode root, int depth, int index, List<Integer> leftIndex) {
        if (root == null) return 0;
        // we will store all the left side node indices, which is the same as left view though
        if (depth == leftIndex.size()) leftIndex.add(index);
        // we will check the width with the left most node
        int width = index - leftIndex.get(depth) + 1;
        // we will also check if there is any higher width present or not in its left and right node
        int left = dfs(root.left, depth + 1, index * 2, leftIndex);
        int right = dfs(root.right, depth + 1, index * 2 + 1, leftIndex);
        // lastly, we will return the highest one among all
        return Math.max(width, Math.max(left, right));
    }


    // if we have to count only the non-null node then we could just store the nodes
    // in queue and at last we can just take the size, but we have to also keep
    // track of the null nodes in between, so we will set numbers for each node and
    // in each level we will take the difference of the first node number to last
    // node number, the difference will tell us the nodes in between
    private static void type1() {
        TNode root = TNode.withCount(15);
        LinkedList<Node> deque = new LinkedList<>();
        deque.add(new Node(root, 0));
        int max = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            // we will add a new level into deque from the current level
            for (int i = 0; i < size; i++) {
                Node node = deque.poll();
                int n = node.n;
                TNode tnode = node.node;
                if (null != tnode.left) deque.offer(new Node(tnode.left, 2 * n + 1));
                if (null != tnode.right) deque.offer(new Node(tnode.right, 2 * n + 2));
            }
			//
            if (deque.isEmpty()) break;
            max = Math.max(max, deque.getLast().n - deque.getFirst().n + 1);
        }
        System.out.println(max);
    }

    public static class Node {
        public TNode node;
        public int n;

        public Node(TNode node, int n) {
            this.node = node;
            this.n = n;
        }
    }
}
