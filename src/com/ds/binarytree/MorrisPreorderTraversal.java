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
        List<Integer> answer = preorderTraversal(root);
        System.out.println(answer);
    }

    private static List<Integer> preorderTraversal(TNode root) {
        TNode node = root;
        List<Integer> answer = new ArrayList<>();
        while (null != node) {
            if (null == node.left) {
                answer.add(node.data);
                node = node.right;
            } else {
                TNode temp = node.left;
                while (null != temp.right && temp.right != node)
                    temp = temp.right;
                if (temp.right == null) {
                    temp.right = node;
                    answer.add(node.data);
                    node = node.left;
                } else {
                    temp.right = null;
                    node = node.right;
                }
            }
        }
        return answer;
    }

}
