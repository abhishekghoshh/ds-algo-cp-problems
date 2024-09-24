package com.problems.binarysearchtree;

import com.ds.binarytree.TNode;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link :
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/
 * Solution link :
 *
 *
 */
public class MaximumSumBSTInBinaryTree {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    private static void type3() {

    }

    private static void type2() {

    }

    int maxSum2 = Integer.MIN_VALUE;
    Map<TNode, Integer> map2 = new HashMap<>();

    public int maxSumBST(TNode root) {
        isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return Math.max(0, maxSum2);
    }

    public boolean isBST(TNode root, int min, int max) {
        if (root == null) return true;
        int val = root.data;
        if (min < val && val < max && isBST(root.left, min, val) && isBST(root.right, val, max)) {
            int leftSum = (root.left != null) ? map2.get(root.left) : 0;
            int rightSum = (root.right != null) ? map2.get(root.right) : 0;
            int sum = val + leftSum + rightSum;
            map2.put(root, sum);
            maxSum2 = Math.max(maxSum2, sum);
            return true;
        }
        isBST(root.left, Integer.MIN_VALUE, Integer.MAX_VALUE);
        isBST(root.right, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return false;
    }

    // brute force
    private static void type1() {

    }
}
