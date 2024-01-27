package com.ds.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/boundary-of-binary-tree/#
 * https://www.codingninjas.com/codestudio/problems/boundary-traversal_790725
 * https://www.codingninjas.com/studio/problems/boundary-traversal-of-binary-tree_790725
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=0ca1nvR0be4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=21
 * 
 * 
 * https://takeuforward.org/data-structure/boundary-traversal-of-a-binary-tree/
 */
public class BoundaryTraversalInBinaryTree {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// Iterative way
	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(21);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (!isLeaf(root))
			ans.add(root.val);
		addLeftBoundary(root, ans);
		addLeaves(root, ans);
		addRightBoundary(root, ans);
		System.out.println(ans);
	}

	static Boolean isLeaf(TreeNode<Integer> root) {
		return (root.left == null) && (root.right == null);
	}

	static void addLeftBoundary(TreeNode<Integer> root, ArrayList<Integer> res) {
		TreeNode<Integer> node = root.left;
		while (node != null) {
			if (!isLeaf(node))
				res.add(node.val);
			if (node.left != null)
				node = node.left;
			else
				node = node.right;
		}
	}

	static void addRightBoundary(TreeNode<Integer> root, ArrayList<Integer> res) {
		TreeNode<Integer> node = root.right;
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		while (node != null) {
			if (!isLeaf(node))
				tmp.add(node.val);
			if (node.right != null)
				node = node.right;
			else
				node = node.left;
		}
		for (int i = tmp.size() - 1; i >= 0; --i) {
			res.add(tmp.get(i));
		}
	}

	static void addLeaves(TreeNode<Integer> root, ArrayList<Integer> res) {
		if (isLeaf(root)) {
			res.add(root.val);
			return;
		}
		if (root.left != null)
			addLeaves(root.left, res);
		if (root.right != null)
			addLeaves(root.right, res);
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(21);
		List<Integer> answer = new ArrayList<>();
		leftView(root, answer);
		bottomView(root, answer);
		// as for right view it will be reversed so we are creating a stack
		// later we will iterate through it and add the node in the final array
		Stack<Integer> stack = new Stack<>();
		rightView(root, stack);
		// as we don't need the root we will not iterate till empty
		// we will loop until the size is 1
		while (stack.size() != 1)
			answer.add(stack.pop());
		System.out.println(answer);
	}

	private static void rightView(TreeNode<Integer> root, Stack<Integer> stack) {
		// we are also not taking the leaf node as it will be added in the bottom view
		if (null == root || (root.left == null && root.right == null))
			return;
		stack.push(root.val);
		if (null != root.right)
			rightView(root.right, stack);
		else
			rightView(root.left, stack);
	}

	private static void bottomView(TreeNode<Integer> root, List<Integer> answer) {
		if (null == root)
			return;
		// we are only adding for the leaf node
		if (null == root.left && null == root.right) {
			answer.add(root.val);
			return;
		}
		bottomView(root.left, answer);
		bottomView(root.right, answer);

	}

	private static void leftView(TreeNode<Integer> root, List<Integer> answer) {
		// we are also not taking the leaf node as it will be added in the bottom view
		if (null == root || (root.left == null && root.right == null))
			return;
		answer.add(root.val);
		if (null != root.left)
			leftView(root.left, answer);
		else
			leftView(root.right, answer);
	}

}
