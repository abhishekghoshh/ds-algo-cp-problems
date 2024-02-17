package com.ds.binarytree;

import com.algo.binarytree.TNode;
import com.util.PrintUtl;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem link :
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * https://practice.geeksforgeeks.org/problems/inorder-traversal/1
 * https://www.codingninjas.com/studio/problems/inorder-traversal_3839605
 *
 * Solution link :
 * https://www.youtube.com/watch?v=80Zug6D1_r4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=38
 *
 * https://takeuforward.org/data-structure/morris-inorder-traversal-of-a-binary-tree/
 */

public class MorrisInorderTraversal {

    public static void main(String[] args) {
        type1();
    }

    // inorder traversal without using any extra space
    // in order we know that after all the left node is completed then root node
    // will be traversed, the last node of the left side will be the rightest node of
    // the left side, so we will create a link between the rightest node and the root
    // and if there is no left, then we will directly add to list and go to right
    private static void type1() {
        TNode root = TNode.withCount(15);
        PrintUtl.inOrder(root);

        List<Integer> answer = inorderTraversal(root);
        System.out.println(answer);
    }

    private static List<Integer> inorderTraversal(TNode root) {
        TNode node = root;
        List<Integer> answer = new ArrayList<>();
        while (null != node) {
            // left is null
            if (null == node.left) {
                answer.add(node.data);
                node = node.right;
            } else {
                TNode temp = node.left;
                // we will go to the rightest node
                while (null != temp.right && temp.right != node)
                    temp = temp.right;
                // setting the link then, we will go to the left
                if (temp.right == null) {
                    temp.right = node;
                    node = node.left;
                } else {
                    // there was already a link
                    // that means this is the second time we are in the root
                    // so left part is traversed completely
                    // we will now delete the link and add the root to list
                    temp.right = null;
                    answer.add(node.data);
                    node = node.right;
                }
            }
        }
        return answer;
    }
}
