package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=i9ORlEy6EsI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=31
 */
public class PrintAllNodesInBinaryTreeAtDistanceKFromTargetNode {

	// These is a problem of least common ancester
	public static void main(String[] args) {
		type1();
		type2();

		// NOTE solution of Striver is very complex and time consuming. better follow
		// this 2 approach
	}

	// Optimized approach
	// rather storing in the stack and then iterating it we can just find the node
	// with k distances while finding the target
	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(31);
		TreeNode<Integer> target = root.search(5);
		int k = 2;
		List<Integer> list = new ArrayList<>();
		findTarget(root, target, list, k);
		System.out.println(list);
	}

	private static int findTarget(TreeNode<Integer> root, TreeNode<Integer> target, List<Integer> list, int k) {
		if (null == root)
			return -1;
		if (root.val == target.val) {
			// if k ==0 then we can just add the current root and return -1
			// -1 is a flag to stop the findNode operation
			if (k == 0) {
				list.add(root.val);
				return -1;
			}
			findNodes(root.left, k, 1, list);
			findNodes(root.right, k, 1, list);
			return 1;
		}
		int leftDistance = findTarget(root.left, target, list, k);
		int rightDistance = findTarget(root.right, target, list, k);
		if (leftDistance == k || rightDistance == k) {
			list.add(root.val);
			return -1;
		} else if (leftDistance != -1 && leftDistance < k) {
			findNodes(root.right, k - leftDistance, 1, list);
			return leftDistance + 1;
		} else if (rightDistance != -1 && rightDistance < k) {
			findNodes(root.left, k - rightDistance, 1, list);
			return rightDistance + 1;
		} else {
			return -1;
		}
	}

	// this is based on lowest common ancestor
	// we will store store all the ancestors till root
	// with the directions
	// then traverse the stack and for every node we will find all the equal
	// distance nodes from different child
	// when we reach the target we will check all it's child level
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(0, 1, null, 3, 2);
		TreeNode<Integer> target = root.search(2);
		int k = 1;
		Stack<Pair> stack = new Stack<>();
		findPath(root, target, stack);
		int distance = stack.size() - 1;
		List<Integer> list = new ArrayList<>();
		while (!stack.isEmpty()) {
			Pair pair = stack.pop();
			TreeNode<Integer> node = pair.node;
			int flag = pair.flag;
			if (distance < k) {
				if (flag == 1) {
					findNodes(node.left, k - distance, 1, list);
				} else if (flag == -1) {
					findNodes(node.right, k - distance, 1, list);
				} else {
					findNodes(node.left, k - distance, 1, list);
					findNodes(node.right, k - distance, 1, list);
				}
			} else if (distance == k) {
				list.add(node.val);
			}
			distance--;
		}
		System.out.println(list);
	}

	private static void findNodes(TreeNode<Integer> node, int distance, int level, List<Integer> list) {
		if (null == node)
			return;
		if (level == distance) {
			list.add(node.val);
			return;
		}
		findNodes(node.left, distance, level + 1, list);
		findNodes(node.right, distance, level + 1, list);
	}

	private static boolean findPath(TreeNode<Integer> root, TreeNode<Integer> target, Stack<Pair> stack) {
		if (null == root)
			return false;
		if (root.val == target.val) {
			stack.push(new Pair(root, 0));
			return true;
		}
		boolean leftFind = findPath(root.left, target, stack);
		boolean rightFind = findPath(root.right, target, stack);
		if (leftFind)
			stack.push(new Pair(root, -1));
		if (rightFind)
			stack.push(new Pair(root, 1));
		return leftFind || rightFind;
	}

	public static class Pair {
		public TreeNode<Integer> node;
		public int flag;

		public Pair(TreeNode<Integer> node, int flag) {
			this.node = node;
			this.flag = flag;
		}

		@Override
		public String toString() {
			return "[=" + node.val + "," + flag + "]";
		}
	}
}
