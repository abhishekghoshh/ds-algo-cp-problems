package com.ds.binarytree;

import com.algo.binarytree.TNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem link :
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 * https://www.codingninjas.com/studio/problems/right-view_764605
 * https://www.geeksforgeeks.org/problems/right-view-of-binary-tree/1
 *
 * Solution link :
 * https://www.youtube.com/watch?v=KV4mRzTjlAk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=25
 *
 * https://takeuforward.org/data-structure/right-left-view-of-binary-tree/
 */
public class RightViewOfBinaryTree {
    public static void main(String[] args) {
        type1();
        type2();
    }

    // iterative way
    // TODO complete it later
    private static void type2() {
        TNode root = TNode.withCount(15);
        List<Integer> rightView = rightViewTraversal(root);
        System.out.println(rightView);
    }

    static List<Integer> rightViewTraversal(TNode root) {
        List<Integer> rightView = new ArrayList<>();
        TNode node = root;

        return rightView;
    }

    // using dfs / recursion
    private static void type1() {
        TNode root = TNode.withCount(15);
        ArrayList<Integer> rightView = new ArrayList<>();
        rightViewTraversal(root, rightView, 0);
        System.out.println(rightView);
    }

    // it will go to most right, and if there is one level found then it will add that to list
    private static void rightViewTraversal(TNode root, List<Integer> rightView, int level) {
        if (null == root) return;
        if (rightView.size() == level) rightView.add(root.data);
        rightViewTraversal(root.right, rightView, level + 1);
        rightViewTraversal(root.left, rightView, level + 1);
    }
}
