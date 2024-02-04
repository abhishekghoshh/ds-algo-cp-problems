package com.ds.binarysearchtree;

import util.TreeNode;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/largest-bst/1
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=X0oXMdtUDwo&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=54
 * 
 * 
 */
public class LargestBinarySearchTreeInBinaryTree {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.makeBST(35);
		NodeValue nodeValue = largestBSTSubtree(root);
		System.out.println(nodeValue.maxSize);
	}

	private static class NodeValue {
		public int maxNode, minNode, maxSize;

		NodeValue(int minNode, int maxNode, int maxSize) {
			this.maxNode = maxNode;
			this.minNode = minNode;
			this.maxSize = maxSize;
		}
	};

	private static NodeValue largestBSTSubtree(TreeNode<Integer> root) {
		// An empty tree is a BST of size 0.
		if (root == null)
			return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		// Get values from left and right subtree of current tree.
		NodeValue left = largestBSTSubtree(root.left);
		NodeValue right = largestBSTSubtree(root.right);
		// Current node is greater than max in left AND
		// smaller than min in right it is a BST.
		if (left.maxNode < root.val && root.val < right.minNode)
			// It is a BST.
			return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode),
					left.maxSize + right.maxSize + 1);
		// Otherwise, return [-inf, inf] so that parent can't be valid BST
		return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
	}

}
