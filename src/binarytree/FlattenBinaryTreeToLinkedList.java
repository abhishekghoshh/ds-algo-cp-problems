package binarytree;

import java.util.Stack;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * https://practice.geeksforgeeks.org/problems/flatten-binary-tree-to-linked-list/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=sWf7k1x9XR4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=39
 * 
 * https://takeuforward.org/data-structure/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {
	public static void main(String[] args) {
		type0();
		type1();
		type2();
		type3();
	}

	private static void type3() {
		TreeNode<Integer> root = util.TreeNode.withCount(15);
		flat(root);
	}

	@SuppressWarnings("unchecked")
	public static TreeNode<Integer>[] flat(TreeNode<Integer> root) {
		if (null == root)
			return null;
		TreeNode<Integer> start = root, end = root;
		TreeNode<Integer>[] left = flat(root.left);
		TreeNode<Integer>[] right = flat(root.right);
		if (null != left) {
			root.left = null;
			root.right = left[0];
			end = left[1];
		}
		if (null != right) {
			end.right = right[0];
			end = right[1];
		}
		return new TreeNode[] { start, end };
	}

	private static void type2() {
		TreeNode<Integer> root = util.TreeNode.withCount(15);
		flatten_(root);
	}

	public static void flatten_(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		flatten_(root.right);
		flatten_(root.left);
		TreeNode<Integer> last = root.right;
		root.right = root.left;
		root.left = null;
		while (root.right != null)
			root = root.right;
		root.right = last;
	}

	private static void type1() {
		TreeNode<Integer> root = util.TreeNode.withCount(15);
		TreeNode<Integer> cur = root;
		while (cur != null) {
			if (cur.left != null) {
				TreeNode<Integer> pre = cur.left;
				while (pre.right != null) {
					pre = pre.right;
				}
				pre.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
			cur = cur.right;
		}
	}

	private static void type0() {
		TreeNode<Integer> root = util.TreeNode.withCount(15);
		if (root == null)
			return;
		Stack<TreeNode<Integer>> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode<Integer> current = stack.pop();
			if (current.right != null)
				stack.push(current.right);
			if (current.left != null)
				stack.push(current.left);
			if (!stack.isEmpty())
				current.right = stack.peek();
			current.left = null;
		}
	}
}