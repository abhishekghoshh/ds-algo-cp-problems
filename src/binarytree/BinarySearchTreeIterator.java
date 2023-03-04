package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=D2jMcmxU4bs&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=51
 * 
 * 
 */
public class BinarySearchTreeIterator {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {
		TreeNode<Integer> root = TreeNode.makeBST(31);
		BstIterator3 bstIterator = new BstIterator3(root);
		while (bstIterator.hasNext()) {
			System.out.print(bstIterator.next() + " ");
		}
		System.out.println();
	}

	private static class BstIterator3 {
		TreeNode<Integer>[] stack;
		int top = -1;
		int n = 1000000;

		public BstIterator3(TreeNode<Integer> root) {
			stack = (TreeNode<Integer>[]) new TreeNode[n];
			pushAllLeft(root, stack);
		}

		private void pushAllLeft(TreeNode<Integer> root, TreeNode<Integer>[] stack2) {
			while (null != root) {
				stack[++top] = root;
				root = root.left;
			}
		}

		public int next() {
			TreeNode<Integer> node = stack[top--];
			pushAllLeft(node.right, stack);
			return node.val;
		}

		public boolean hasNext() {
			return top != -1;
		}
	}

	// time complexity of next function in O(1)
	// space complexity O(log(n))
	// here we are not storing the whole inorder traversal
	// we are just storing the left most child
	// in a sense we are storing only one full recursion depth into the stack
	// on every next call we just returning the stack top element because it is the
	// most left element and in inorder we have to return the left mode element
	// and also we are checking if the node has any right node
	private static void type2() {
		TreeNode<Integer> root = TreeNode.makeBST(31);
		BstIterator2 bstIterator = new BstIterator2(root);
		while (bstIterator.hasNext()) {
			System.out.print(bstIterator.next() + " ");
		}
		System.out.println();
	}

	public static class BstIterator2 {
		Stack<TreeNode<Integer>> stack;

		public BstIterator2(TreeNode<Integer> root) {
			stack = new Stack<>();
			pushAllLeft(root, stack);
		}

		private void pushAllLeft(TreeNode<Integer> root, Stack<TreeNode<Integer>> stack) {
			while (null != root) {
				stack.push(root);
				root = root.left;
			}
		}

		public int next() {
			TreeNode<Integer> node = stack.pop();
			pushAllLeft(node.right, stack);
			return node.val;
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}
	}

	// time complexity of next function in O(1)
	// space complexity O(n)
	private static void type1() {
		TreeNode<Integer> root = TreeNode.makeBST(31);
		BstIterator1 bstIterator = new BstIterator1(root);
		while (bstIterator.hasNext()) {
			System.out.print(bstIterator.next() + " ");
		}
		System.out.println();
	}

	public static class BstIterator1 {
		private List<Integer> inorder;
		private int index;

		public BstIterator1(TreeNode<Integer> root) {
			inorder = new ArrayList<>();
			index = 0;
			build(root);
		}

		private void build(TreeNode<Integer> node) {
			if (node == null)
				return;
			build(node.left);
			inorder.add(node.val);
			build(node.right);
		}

		public int next() {
			if (hasNext()) {
				return inorder.get(index++);
			} else {
				return -1;
			}
		}

		public boolean hasNext() {
			return index < inorder.size();
		}
	}
}
