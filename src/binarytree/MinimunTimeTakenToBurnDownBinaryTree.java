package binarytree;

import java.util.Stack;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
 * https://www.codingninjas.com/codestudio/problems/time-to-burn-tree_630563
 * https://practice.geeksforgeeks.org/problems/burning-tree/1
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=2r5wLmQfD6g&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=32
 * 
 * 
 * 
 */
public class MinimunTimeTakenToBurnDownBinaryTree {
	// Given a binary tree and a node data called target. Find the minimum time
	// required to burn the complete binary tree if the target is set on fire. It is
	// known that in 1 second all nodes connected to a given node get burned. That
	// is its left child, right child, and parent.
	// Note: The tree contains unique values.
	// These is a problem of least common ancester
	// same as PrintAllNodesInBinaryTreeAtDistanceKFromTargetNode problem
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static int minDistance = 0;

	// This is the best solution possible
	private static void type3() {
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(1, 5, 3, null, 4, 10, 6, null, null, 9, 2);
		int start = 3;
		traverse(root, start);
		System.out.println(minDistance);
	}

	// here the height and distance is calculated simultaneously
	// once we find the target we are returning the -1
	// here minus distance is regarded as distance from root to target
	// positive distance means the height
	private static int traverse(TreeNode<Integer> node, int start) {
		if (node == null)
			return 0;
		int left = traverse(node.left, start);
		int right = traverse(node.right, start);
		if (left < 0) {
			minDistance = Math.max(minDistance, right - left);
			return left - 1;
		} else if (right < 0) {
			minDistance = Math.max(minDistance, left - right);
			return right - 1;
		} else if (node.val == start) {
			minDistance = Math.max(left, right);
			return -1;
		} else {
			return Math.max(left, right) + 1;
		}
	}

	private static void type2() {
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(1, 5, 3, null, 4, 10, 6, null, null, 9, 2);
//		System.out.println(root.levelOrder());
		int target = 3;
		int[] minDistance = { Integer.MIN_VALUE };
		findTarget(root, target, minDistance);
		System.out.println(minDistance[0]);
	}

	private static int findTarget(TreeNode<Integer> root, int target, int[] minDistance) {
		if (null == root)
			return -1;
		if (root.val == target) {
			minDistance[0] = Math.max(minDistance[0], height(root.left));
			minDistance[0] = Math.max(minDistance[0], height(root.right));
			return 1;
		}
		int leftDistance = findTarget(root.left, target, minDistance);
		int rightDistance = findTarget(root.right, target, minDistance);
		if (leftDistance == -1 && rightDistance == -1) {
			return -1;
		} else if (leftDistance != -1) {
			minDistance[0] = Math.max(minDistance[0], leftDistance + height(root.right));
			return leftDistance + 1;
		} else {
			minDistance[0] = Math.max(minDistance[0], rightDistance + height(root.left));
			return rightDistance + 1;
		}
	}

	// store all the parents in stack
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(31);
		int target = 5;
		Stack<Object[]> stack = new Stack<>();
		findPath(root, target, stack);
		int minDistance = Integer.MIN_VALUE;
		int size = stack.size();
		while (!stack.isEmpty()) {
			Object[] pair = stack.pop();
			TreeNode<Integer> node = (TreeNode<Integer>) pair[0];
			int flag = (int) pair[1];
			if (flag == 0) {
				minDistance = Math.max(height(node.left), minDistance);
				minDistance = Math.max(height(node.right), minDistance);
			} else if (flag == 1) {
				minDistance = Math.max(height(node.left) + size - 1, minDistance);
			} else {
				minDistance = Math.max(height(node.right) + size - 1, minDistance);
			}
			size--;
		}
		System.out.println(minDistance);
	}

	private static int height(TreeNode<Integer> node) {
		if (null == node)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}

	private static boolean findPath(TreeNode<Integer> root, int target, Stack<Object[]> stack) {
		if (null == root)
			return false;
		if (root.val == target) {
			stack.push(new Object[] { root, 0 });
			return true;
		}
		boolean leftFind = findPath(root.left, target, stack);
		boolean rightFind = findPath(root.right, target, stack);
		if (leftFind)
			stack.push(new Object[] { root, -1 });
		if (rightFind)
			stack.push(new Object[] { root, 1 });
		return leftFind || rightFind;
	}

}
