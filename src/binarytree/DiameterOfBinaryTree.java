package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * https://www.codingninjas.com/codestudio/problems/920552
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=Rezetez59Nk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=17
 * https://www.youtube.com/watch?v=zmPj_Ee3B8c&list=PL_z_8CaSLPWfxJPz2-YKqL9gXWdgrhvdn&index=3
 * 
 * https://takeuforward.org/data-structure/calculate-the-diameter-of-a-binary-tree/
 * */
public class DiameterOfBinaryTree {

	public static void main(String args[]) {
		type1();
		type2();
		type3();
	}

	private static int diameter = 0;

	private static void type3() {
		TreeNode<Integer> root = TreeNode.withCount(16);
		height(root);
		System.out.println(diameter);
	}

	private static int height(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int lh = height(root.left);
		int rh = height(root.right);
		diameter = Math.max(diameter, lh + rh);
		return 1 + Math.max(lh, rh);
	}

	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(16);
		int[] diameter = new int[1];
		height(root, diameter);
		System.out.println(diameter[0]);

	}

	private static int height(TreeNode<Integer> root, int[] diameter) {
		if (root == null) {
			return 0;
		}
		int lh = height(root.left, diameter);
		int rh = height(root.right, diameter);
		diameter[0] = Math.max(diameter[0], lh + rh);
		return 1 + Math.max(lh, rh);
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(16);
		Diameter diameter = new Diameter();
		height(root, diameter);
		System.out.println(diameter.data);
	}

	// we will compute height and side by we will compute the diameter
	private static int height(TreeNode<Integer> root, Diameter daimeter) {
		if (null == root) {
			return 0;
		}
		int leftHeight = height(root.left, daimeter);
		int rightHeight = height(root.right, daimeter);
		// we just computing the diameter and updating it
		// diameter of the a node is 1 + leftHeight + rightHeight
		daimeter.data = Math.max(daimeter.data, leftHeight + rightHeight);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	private static class Diameter {
		public int data = 0;
	}

}
