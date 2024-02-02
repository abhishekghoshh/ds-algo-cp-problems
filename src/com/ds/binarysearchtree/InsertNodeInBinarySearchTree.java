package com.ds.binarysearchtree;

import com.algo.binarytree.TNode;
import com.util.PrintUtl;

/*
 * Problem link :
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * https://practice.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1
 * https://www.codingninjas.com/studio/problems/insert-into-a-binary-search-tree_1279913
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=FiFiNvM29ps&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=44
 *
 * https://takeuforward.org/binary-search-tree/insert-a-given-node-in-binary-search-tree/
 */
public class InsertNodeInBinarySearchTree {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// iterative way of adding nodes to the leaf
	private static void type2() {
		TNode root = TNode.withNodes(4, 2, 7, 1, 3);
		int val = 5;
		root = insertIntoBST2(root, val);
		PrintUtl.levelOrder(root);
	}

	private static TNode insertIntoBST2(TNode root, int target) {
		if (root == null) return new TNode(target);
		TNode node = root;
		while (null != node) {
			// we will go to the left if the target is lesser than the node
			if (target < node.data) {
				// if the left is null, then we will successfully place the node there
				if (node.left == null) {
					node.left = new TNode(target);
					break;
				}
				node = node.left;
			} else {
				// we will go to the right if the target is greater than the node
				// if the right is null, then we will successfully place the node there
				if (node.right == null) {
					node.right = new TNode(target);
					break;
				}
				node = node.right;
			}
		}
		return root;
	}

	// recursive way of adding nodes to the leaf
	private static void type1() {
		TNode root = TNode.withNodes(4, 2, 7, 1, 3);
		PrintUtl.levelOrder(root);
		root = insertIntoBST1(root, 5);
		PrintUtl.levelOrder(root);

	}

	public static TNode insertIntoBST1(TNode root, int target) {
		// if the root is null, then we will assign a new node
		if (root == null) return new TNode(target);
		// if the target is lesser than the root, then we will go to the left side
		// we will go until the root is null
		if (target < root.data)
			root.left = insertIntoBST1(root.left, target);
		else
			root.right = insertIntoBST1(root.right, target);
		return root;
	}
}
