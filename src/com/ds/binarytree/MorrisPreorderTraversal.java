package com.ds.binarytree;

import com.algo.binarytree.TNode;
import com.util.PrintUtl;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem link :
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * https://practice.geeksforgeeks.org/problems/preorder-traversal/1
 * https://www.codingninjas.com/studio/problems/preorder-binary-tree_5948
 *
 * Solution link :
 * https://www.youtube.com/watch?v=80Zug6D1_r4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=38
 *
 * https://takeuforward.org/data-structure/morris-preorder-traversal-of-a-binary-tree/
 */
public class MorrisPreorderTraversal {

    public static void main(String[] args) {
        type1();
    }

    // preorder traversal without using any extra space
    // same as inorder but here we are adding the root at the first time when we are
    // seeing this, that means no link is not set yet
    private static void type1() {
        TNode root = TNode.withCount(15);
        PrintUtl.preOrder(root);

        TNode curr = root;

        List<Integer> answer = new ArrayList<>();
        while (null != curr) {
            if (null == curr.left) {
                answer.add(curr.data);
                curr = curr.right;
            } else {
                TNode temp = curr.left;
                while (null != temp.right && temp.right != curr)
                    temp = temp.right;
                if (temp.right == null) {
                    temp.right = curr;
                    answer.add(curr.data);
                    curr = curr.left;
                } else {
                    temp.right = null;
                    curr = curr.right;
                }
            }
        }
        System.out.println(answer);
    }

}
