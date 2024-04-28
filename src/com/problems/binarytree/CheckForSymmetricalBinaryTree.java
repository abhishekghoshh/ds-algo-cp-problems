package com.problems.binarytree;

import com.ds.binarytree.TNode;

/*
 * Problem link :
 * https://leetcode.com/problems/symmetric-tree/
 * https://www.codingninjas.com/codestudio/problems/630426
 * https://www.codingninjas.com/studio/problems/symmetric-tree_981177
 *
 * Solution link :
 * https://www.youtube.com/watch?v=nKggNAiEpBE&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=26
 *
 * https://takeuforward.org/data-structure/check-for-symmetrical-binary-tree/
 */
public class CheckForSymmetricalBinaryTree {

    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        TNode root = TNode.withNodes(1, 2, 2, 3, 4, 4, 3);
        boolean isSymmetric = isSymmetric(root);
        System.out.println(isSymmetric);
    }

    private static boolean isSymmetric(TNode root) {
        if (null == root) return true;
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TNode root1, TNode root2) {
        // if both are null, then it is symmetric
        if (null == root1 && null == root2) return true;
        // if either is null, then it is not symmetric
        if (null == root1 || null == root2) return false;
        // if both is non-null, then first we will check the values of the node
        // as we are checking the symmetric, so we will now check cris-cross
        return root1.data == root2.data
                && isSymmetric(root1.left, root2.right)
                && isSymmetric(root1.right, root2.left);
    }
}
