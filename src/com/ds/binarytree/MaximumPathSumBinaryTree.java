package com.ds.binarytree;

import com.algo.binarytree.TNode;

/*
 * Problem link :
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * https://www.codingninjas.com/codestudio/problems/794950
 * https://www.codingninjas.com/studio/problems/maximum-sum-path-of-a-binary-tree._1214968
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=WszrfSwMz58&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=18
 * https://www.youtube.com/watch?v=Osz-Vwer6rw&list=PL_z_8CaSLPWfxJPz2-YKqL9gXWdgrhvdn&index=4
 * 
 * https://takeuforward.org/data-structure/maximum-sum-path-in-binary-tree/
 * */
public class MaximumPathSumBinaryTree {

	// A path in a binary tree is a sequence of nodes where each pair of adjacent
	// nodes in the sequence has an edge connecting them. A node can only appear in
	// the sequence at most once. Note that the path does not need to pass through
	// the root.
	// The path sum of a path is the sum of the node's values in the path.
	// Given the root of a binary tree, return the maximum path sum of any non-empty
	// path.
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static int MAX_PATH = Integer.MIN_VALUE;

	// same as previous 2
	// we are using class variable here
	private static void type3() {
		TNode root = TNode.withNodes(1, 2, 3, -2, -1);
		maxPath(root);
		System.out.println(MAX_PATH);
	}

	private static int maxPath(TNode node) {
		if (node == null) return 0;
		int leftMax = Math.max(maxPath(node.left), 0);
		int rightMax = Math.max(maxPath(node.right), 0);
		MAX_PATH = Math.max(MAX_PATH, leftMax + rightMax + node.data);
		return node.data + Math.max(leftMax, rightMax);
	}

	private static void type2() {
		TNode root = TNode.withNodes(1, 2, 3, -2, -1);
		int[] maxValue = {Integer.MIN_VALUE};
		maxPath(root, maxValue);
		System.out.println(maxValue[0]);
	}

	public static int maxPath(TNode node, int[] data) {
		if (node == null) return 0;
		int left = Math.max(0, maxPath(node.left, data));
		int right = Math.max(0, maxPath(node.right, data));
		// calculating the max path sum
		data[0] = Math.max(data[0], left + right + node.data);
		return node.data + Math.max(left, right);
	}

	// explain this
	private static void type1() {
		TNode root = TNode.withNodes(1, 2, 3, -2, -1);
		Data data = new Data();
		maxPath(root, data);
		System.out.println(data.data);
	}

	private static int maxPath(TNode root, Data data) {
		if (null == root) return 0;
		// if left is negative, then we will discard left as we are not considering leaf
		// node here, as we need any node to any node sum
		// if leaf to leaf sum required, then we should not discard any value
		int left = maxPath(root.left, data);
		if (left < 0) left = 0;
		// if right is negative, then we will discard right
		int right = maxPath(root.right, data);
		if (right < 0) right = 0;
		// max path root.value + left sum + right sum
		data.data = Math.max(data.data, root.data + left + right);
		// at this time left or right is either 0 or any positive value
		// max between a left path and right path
		return root.data + Math.max(left, right);
	}

	static class Data {
		public int data = Integer.MIN_VALUE;
	}

}
