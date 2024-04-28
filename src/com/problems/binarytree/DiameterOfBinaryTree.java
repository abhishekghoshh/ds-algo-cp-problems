package com.problems.binarytree;

import com.ds.binarytree.TNode;

/*
 * Problem link :
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * https://www.codingninjas.com/codestudio/problems/920552
 * https://www.codingninjas.com/studio/problems/diameter-of-binary-tree_920552
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=Rezetez59Nk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=17
 * https://www.youtube.com/watch?v=zmPj_Ee3B8c&list=PL_z_8CaSLPWfxJPz2-YKqL9gXWdgrhvdn&index=3
 * 
 * https://takeuforward.org/data-structure/calculate-the-diameter-of-a-binary-tree/
 * */
public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static int MAX_DIAMETER = 0;

	// using the class level variable to store the max diameter
	private static void type3() {
		TNode root = TNode.withCount(16);
		height(root);
		System.out.println(MAX_DIAMETER);
	}

	private static int height(TNode root) {
		if (root == null) return 0;
		int lh = height(root.left);
		int rh = height(root.right);
		MAX_DIAMETER = Math.max(MAX_DIAMETER, lh + rh);
		return 1 + Math.max(lh, rh);
	}

	// same as previous just here we are using one array,
	// and it will have only one item for storing the diameter
	private static void type2() {
		TNode root = TNode.withCount(16);
		int[] diameter = new int[1];
		height(root, diameter);
		System.out.println(diameter[0]);

	}

	private static int height(TNode root, int[] diameter) {
		if (root == null) return 0;
		int lh = height(root.left, diameter);
		int rh = height(root.right, diameter);
		diameter[0] = Math.max(diameter[0], lh + rh);
		return 1 + Math.max(lh, rh);
	}

	private static void type1() {
		TNode root = TNode.withCount(16);
		Data diameter = new Data();
		height(root, diameter);
		System.out.println(diameter.data);
	}

	// we will compute height and side by we will compute the diameter
	private static int height(TNode root, Data data) {
		if (null == root) return 0;
		int leftH = height(root.left, data);
		int rightH = height(root.right, data);
		// we're just computing the diameter and updating the
		// diameter of a node is leftHeight + rightHeight
		data.data = Math.max(data.data, leftH + rightH);
		return 1 + Math.max(leftH, rightH);
	}

	private static class Data {
		public int data = 0;
	}

}
