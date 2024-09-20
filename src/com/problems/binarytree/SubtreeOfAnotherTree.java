package com.problems.binarytree;

import com.ds.binarytree.TNode;

/*
 *
 * problem links :
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 *
 * Solution link :
 *
 * https://takeuforward.org/data-structure/reorder-list/
 * */
public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        type1();
    }

    // this is the simple approach using dfs
    // we will dfs till we find the same value
    // once we find the same value we will check from this node if both of the tree is identical or not
    private static void type1() {
        TNode root = TNode.withCount(15);
        TNode subRoot = TNode.withNodes(7, 14, 15);
        boolean ans = isSubtree(root, subRoot);
        System.out.println(ans);
    }

    public static boolean isSubtree(TNode root, TNode subRoot) {
        if (null == root) return false;
        // if both values are same, then we will check if both tree are identical
        if (root.data == subRoot.data && isSameTree(root, subRoot)) return true;
        // else we will go for left and right child
        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TNode root, TNode subRoot) {
        // if both are null means both are identical
        if (null == root && null == subRoot) return true;
        // if anyone of them is non-null then, it is not identical
        if (null == root || null == subRoot) return false;
        // then we will check if the values are same and its left and right child is also same or not
        return (root.data == subRoot.data)
                && isSameTree(root.left, subRoot.left)
                && isSameTree(root.right, subRoot.right);
    }
}
