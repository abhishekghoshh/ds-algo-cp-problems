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
		type00_();
		type0_();
		type1_();
		type2_();
		type3_();
	}

	private static void type3_() {
		TreeNode<Integer> root = util.TreeNode.withCount(15);
		flat(root);
		System.out.println(root.preOrder());
	}

	@SuppressWarnings("unchecked")
	// every function call will flat the tree and give me the start node and last
	// node of that list
	// so currently I have root then start node of the left side list and last node
	// of the left side list, and also the first node of the right side list and
	// last node of the right side list
	// now my work is connect this sequence
	// root -> left side list start
	// left side list end -> right side list start
	// now I have
	// root ---> right side list end
	public static TreeNode<Integer>[] flat(TreeNode<Integer> root) {
		if (null == root)
			return null;
		TreeNode<Integer> last = root;
		TreeNode<Integer>[] leftSideList = flat(root.left);
		TreeNode<Integer>[] rightSideList = flat(root.right);
		if (null != leftSideList) {
			root.left = null;
			root.right = leftSideList[0];
			last = leftSideList[1];
		}
		if (null != rightSideList) {
			last.right = rightSideList[0];
			last = rightSideList[1];
		}
		return new TreeNode[] { root, last };
	}

	private static void type2_() {
		TreeNode<Integer> root = util.TreeNode.withCount(15);
		flatten(root);
		System.out.println(root.preOrder());
	}

	public static void flatten(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		flatten(root.right);
		flatten(root.left);
		TreeNode<Integer> last = root.right;
		root.right = root.left;
		root.left = null;
		while (root.right != null)
			root = root.right;
		root.right = last;
	}

	// morris traversal
	// check striver solution
	private static void type1_() {
		TreeNode<Integer> root = util.TreeNode.withCount(15);
		TreeNode<Integer> curr = root;
		while (curr != null) {
			if (curr.left != null) {
				TreeNode<Integer> prev = curr.left;
				while (prev.right != null) {
					prev = prev.right;
				}
				prev.right = curr.right;
				curr.right = curr.left;
				curr.left = null;
			}
			curr = curr.right;
		}
		System.out.println(root.preOrder());
	}

	// same as previous
	// iterative preorder
	// check striver solution
	private static void type0_() {
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
		System.out.println(root.preOrder());
	}

	// check striver solution
	// using reverse pre order
	private static void type00_() {
		TreeNode<Integer> root = util.TreeNode.withCount(15);
		if (root == null)
			return;
		reversePostOrder(root);
		System.out.println(root.preOrder());
	}

	private static TreeNode<Integer> prev = null;

	private static void reversePostOrder(TreeNode<Integer> root) {
		if (root == null)
			return;
		reversePostOrder(root.right);
		reversePostOrder(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}
}