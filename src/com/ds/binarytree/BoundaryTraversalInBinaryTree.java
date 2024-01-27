package com.ds.binarytree;

import com.algo.binarytree.TNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
		TNode root = TNode.withCount(21);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (!isLeaf(root)) ans.add(root.data);
		addLeftBoundary(root, ans);
		addLeaves(root, ans);
		addRightBoundary(root, ans);
		System.out.println(ans);
	}


	static void addLeftBoundary(TNode root, ArrayList<Integer> res) {
		TNode node = root.left;
		while (node != null) {
			if (!isLeaf(node))
				res.add(node.data);
			if (node.left != null)
				node = node.left;
			else
				node = node.right;
		}
	}

	static void addRightBoundary(TNode root, ArrayList<Integer> res) {
		TNode node = root.right;
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		while (node != null) {
			if (!isLeaf(node))
				tmp.add(node.data);
			if (node.right != null)
				node = node.right;
			else
				node = node.left;
		}
		for (int i = tmp.size() - 1; i >= 0; --i) {
			res.add(tmp.get(i));
		}
	}

	static void addLeaves(TNode root, ArrayList<Integer> res) {
		if (isLeaf(root)) {
			res.add(root.data);
			return;
		}
		if (root.left != null)
			addLeaves(root.left, res);
		if (root.right != null)
			addLeaves(root.right, res);
	}

	private static void type1() {
		TNode root = TNode.withCount(21);
		List<Integer> answer = new ArrayList<>();
		leftView(root, answer);
		bottomView(root, answer);
		// as for right view it will be reversed so we are creating a stack
		// later we will iterate through it and add the node in the final array
		Stack<Integer> stack = new Stack<>();
		rightView(root, stack);
		// as we don't need the root, we will not iterate till empty
		// we will loop until the size is 1
		while (stack.size() > 1) answer.add(stack.pop());
		System.out.println(answer);
	}

	private static void rightView(TNode root, Stack<Integer> stack) {
		// we are also not taking the leaf node as it will be added in the bottom view
		if (null == root || isLeaf(root)) return;
		stack.push(root.data);
		if (null != root.right) rightView(root.right, stack);
		else rightView(root.left, stack);
	}

	private static void bottomView(TNode root, List<Integer> answer) {
		if (null == root) return;
		// we are only adding for the leaf node
		if (isLeaf(root)) {
			answer.add(root.data);
			return;
		}
		bottomView(root.left, answer);
		bottomView(root.right, answer);

	}

	private static void leftView(TNode root, List<Integer> answer) {
		// we are also not taking the leaf node as it will be added in the bottom view
		if (null == root || isLeaf(root)) return;
		answer.add(root.data);
		if (null != root.left) leftView(root.left, answer);
		else leftView(root.right, answer);
	}

	static Boolean isLeaf(TNode root) {
		return (root.left == null) && (root.right == null);
	}

}
