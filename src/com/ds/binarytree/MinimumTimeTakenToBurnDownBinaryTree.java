package com.ds.binarytree;

import com.algo.binarytree.TNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.algo.binarytree.TNode.NULL;

/*
 * Problem link :
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
 * https://www.codingninjas.com/codestudio/problems/time-to-burn-tree_630563
 * https://practice.geeksforgeeks.org/problems/burning-tree/1
 * https://www.codingninjas.com/studio/problems/time-to-burn-tree_1469067
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=2r5wLmQfD6g&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=32
 * 
 * 
 * 
 */
public class MinimumTimeTakenToBurnDownBinaryTree {
	// Given a binary tree and a node data called target. Find the minimum time
	// required to burn the complete binary tree if the target is set on fire. It is
	// known that in 1 second, all nodes connected to a given node get burned. That
	// is its left child, right child, and parent.
	// Note: The tree contains unique values.
	// There is a problem of the least common ancestor
	// same as PrintAllNodesInBinaryTreeAtDistanceKFromTargetNode problem
	public static void main(String[] args) {
		// NOTE the solution of Striver is very complex and time-consuming.
		type1();
		type2();
		type3();
		type4();
	}

	private static int minDistance = 0;

	// This is the best solution possible
	private static void type4() {
		TNode root = TNode.withNodes(1, 5, 3, NULL, 4, 10, 6, NULL, NULL, 9, 2);
		int start = 3;
		traverse(root, start);
		System.out.println(minDistance);
	}

	// here the height and distance is calculated simultaneously
	// once we find the target we are returning the -1
	// here minus distance is regarded as distance from root to target
	// positive distance means the height
	private static int traverse(TNode node, int start) {
		if (node == null) return 0;
		int left = traverse(node.left, start);
		int right = traverse(node.right, start);
		if (left < 0) {
			minDistance = Math.max(minDistance, right - left);
			return left - 1;
		} else if (right < 0) {
			minDistance = Math.max(minDistance, left - right);
			return right - 1;
		} else if (node.data == start) {
			minDistance = Math.max(left, right);
			return -1;
		} else {
			return Math.max(left, right) + 1;
		}
	}

	// this is a very optimized approach
	// here we are
	private static void type3() {
		TNode root = TNode.withNodes(1, 5, 3, NULL, 4, 10, 6, NULL, NULL, 9, 2);
		int target = 3;
		int[] minDistance = { Integer.MIN_VALUE };
		findTarget(root, target, minDistance);
		System.out.println(minDistance[0]);
	}

	private static int findTarget(TNode root, int target, int[] minDistance) {
		if (null == root) return -1;
		if (root.data == target) {
			minDistance[0] = Math.max(minDistance[0], height(root.left));
			minDistance[0] = Math.max(minDistance[0], height(root.right));
			return 1;
		}
		int leftDistance = findTarget(root.left, target, minDistance);
		if (leftDistance != -1) {
			minDistance[0] = Math.max(minDistance[0], leftDistance + height(root.right));
			return leftDistance + 1;
		}
		int rightDistance = findTarget(root.right, target, minDistance);
		if (rightDistance != -1) {
			minDistance[0] = Math.max(minDistance[0], rightDistance + height(root.left));
			return rightDistance + 1;
		}
		return -1;
	}

	// same as previous
	// here we will simplify some things
	// we will use a normal list to store the node in reverse.
	// we are adding the nodes into the list from target node then
	// the parent node and likewise the root node.
	// so with the normal list also we will get the nodes in reverse
	// also we do not need to store the direction of target node if it is left or right.
	// we can check parents to get are they left or right
	private static void type2() {
		TNode root = TNode.withCount(31);
		int target = 5;
		List<TNode> traversal = new ArrayList<>();
		traverseUntilTarget(root, target, traversal);
		TNode child = traversal.get(0);
		TNode parent;
		int maxLevel = Math.max(height(child.left), height(child.right));
		for (int i = 1; i < traversal.size(); i++) {
			parent = traversal.get(i);
			if (parent.left == child)
				maxLevel = Math.max(height(parent.right) + i, maxLevel);
			else
				maxLevel = Math.max(height(parent.left) + i, maxLevel);
			child = parent;
		}
		System.out.println(maxLevel);
	}

	private static boolean traverseUntilTarget(TNode root, int target, List<TNode> traversal) {
		if (root == null) return false;
		// either root is the target or target is found either its left side or right side
		if ((root.data == target)
				|| traverseUntilTarget(root.left, target, traversal)
				|| traverseUntilTarget(root.right, target, traversal)) {
			traversal.add(root);
			return true;
		}
		return false;
	}

	// this is also optimized approach
	// store all the parents in stack
	private static void type1() {
		TNode root = TNode.withCount(31);
		int target = 5;
		Stack<Object[]> stack = new Stack<>();
		findPath(root, target, stack);
		int minDistance = Integer.MIN_VALUE;
		int size = stack.size();
		while (!stack.isEmpty()) {
			Object[] pair = stack.pop();
			TNode node = (TNode) pair[0];
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

	private static int height(TNode node) {
		if (null == node) return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}

	private static boolean findPath(TNode root, int target, Stack<Object[]> stack) {
		if (null == root) return false;
		if (root.data == target) {
			stack.push(new Object[] { root, 0 });
			return true;
		}
		boolean leftFind = findPath(root.left, target, stack);
		boolean rightFind = findPath(root.right, target, stack);
		if (leftFind) stack.push(new Object[] { root, -1 });
		if (rightFind) stack.push(new Object[] { root, 1 });
		return leftFind || rightFind;
	}

}
