package com.ds.binarytree;

import com.algo.binarytree.TNode;

/*
 * Problem link :
 * https://leetcode.com/problems/balanced-binary-tree/
 * https://www.codingninjas.com/codestudio/problems/975497
 * https://www.codingninjas.com/studio/problems/is-height-balanced-binary-tree_975497
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=Yt50Jfbd8Po&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=16
 * 
 * https://takeuforward.org/data-structure/check-if-the-binary-tree-is-balanced-binary-tree/
 */
public class CheckIfTheBinaryTreeIsHeightBalanced {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// little optimized
	// it will calculate height in the same time
	// a tree height cannot be -1
	// if the height is -1 then we will know that it is not balanced.
	// if the left height and right height are positive but the difference
	// between them are not less than equal to 1
	// then also it is not balanced
	private static void type2() {
		TNode root = TNode.withNodes(3, 9, 20, TNode.NULL, TNode.NULL, 15, 7);
		boolean isBalanced = heightAndBalanceCheck(root) != -1;
		System.out.println(isBalanced);
	}

	private static int heightAndBalanceCheck(TNode root) {
		if (null == root) return 0;
		int leftH = heightAndBalanceCheck(root.left);
		if (leftH == -1) return -1;
		int rightH = heightAndBalanceCheck(root.right);
		if (rightH == -1) return -1;
		if (rightH - leftH > 1 || rightH - leftH < -1) return -1;
		return 1 + Math.max(leftH, rightH);
	}

	private static void type1() {
		TNode root = TNode.withNodes(3, 9, 20, TNode.NULL, TNode.NULL, 15, 7);
		boolean isBalanced = isBalanced(root);
		System.out.println(isBalanced);
	}

	// first, it will check left height and right height,
	// and if that are balanced or not
	// then it will go to its left and right
	public static boolean isBalanced(TNode root) {
		if (root == null) return true;
		return Math.abs(height(root.left) - height(root.right)) <= 1
				&& isBalanced(root.left)
				&& isBalanced(root.right);
	}

	static int height(TNode root) {
		if (root == null) return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}


}
