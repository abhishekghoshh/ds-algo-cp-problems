package com.ds.binarysearchtree;


import com.algo.binarytree.TNode;

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
		TNode root = TNode.makeBST(35);
		Node node = largestBSTSubtree(root);
		System.out.println(node.maxSize);
	}

	private static class Node {
		public int maxNode, minNode, maxSize;

		Node(int minNode, int maxNode, int maxSize) {
			this.maxNode = maxNode;
			this.minNode = minNode;
			this.maxSize = maxSize;
		}
	};

	private static Node largestBSTSubtree(TNode root) {
		// An empty tree is a BST of size 0.
		if (root == null)
			return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		// Get values from left and right subtree of the current tree.
		Node left = largestBSTSubtree(root.left);
		Node right = largestBSTSubtree(root.right);
		// Current node is greater than max in left AND
		// smaller than min in right it is a BST.
		if (left.maxNode < root.data && root.data < right.minNode)
			// It is a BST.
			return new Node(Math.min(root.data, left.minNode),
					Math.max(root.data, right.maxNode),
					left.maxSize + right.maxSize + 1);
		// Otherwise, return [-inf, inf] so that parent can't be valid BST
		return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
	}

}
