package com.ds.binarytree;

import com.algo.binarytree.TNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/920519
 * https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
 * https://www.codingninjas.com/studio/problems/left-view-of-binary-tree_625707
 *
 * Solution link :
 * https://www.youtube.com/watch?v=KV4mRzTjlAk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=25
 *
 * https://takeuforward.org/data-structure/right-left-view-of-binary-tree/
 */
public class LeftViewOfBinaryTree {
    public static void main(String[] args) {
        type1();
        type2();
    }

    // iterative way
    // TODO complete it later
    private static void type2() {
        TNode root = TNode.withCount(15);
        List<Integer> leftView = leftViewTraversal(root);
        System.out.println(leftView);
    }

    static List<Integer> leftViewTraversal(TNode root) {
        List<Integer> leftView = new ArrayList<>();
        TNode node = root;

        return leftView;
    }

    // using dfs / recursion
    private static void type1() {
        TNode root = TNode.withCount(15);
        List<Integer> leftView = new ArrayList<>();
        leftViewTraversal(root, leftView, 0);
        System.out.println(leftView);
    }

    // it will go to most left, and if there is one level found, then it will add that to the list
    private static void leftViewTraversal(TNode root, List<Integer> leftView, int level) {
        if (null == root) return;
        if (leftView.size() == level) leftView.add(root.data);
        leftViewTraversal(root.left, leftView, level + 1);
        leftViewTraversal(root.right, leftView, level + 1);
    }

}
