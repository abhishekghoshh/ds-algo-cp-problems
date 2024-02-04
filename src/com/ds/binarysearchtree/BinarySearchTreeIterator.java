package com.ds.binarysearchtree;

import com.algo.binarytree.TNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
		TNode root = TNode.makeBST(31);
		BstIterator3 bstIterator = new BstIterator3(root);
		while (bstIterator.hasNext()) {
			System.out.print(bstIterator.next() + " ");
		}
		System.out.println();
	}

	private static class BstIterator3 {
		TNode[] stack;
		int top = -1;
		int n = 1000000;

		public BstIterator3(TNode root) {
			stack = new TNode[n];
			pushAllLeft(root, stack);
		}

		private void pushAllLeft(TNode root, TNode[] stack2) {
			while (null != root) {
				stack[++top] = root;
				root = root.left;
			}
		}

		public int next() {
			TNode node = stack[top--];
			pushAllLeft(node.right, stack);
			return node.data;
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
	// on every next call we're just returning the stack top element because it is the
	// most left element and in inorder we have to return the left mode element,
	// and also we are checking if the node has any right node
	private static void type2() {
		TNode root = TNode.makeBST(31);
		BstIterator2 bstIterator = new BstIterator2(root);
		while (bstIterator.hasNext()) {
			System.out.print(bstIterator.next() + " ");
		}
		System.out.println();
	}

	public static class BstIterator2 {
		Stack<TNode> stack;

		public BstIterator2(TNode root) {
			stack = new Stack<>();
			pushAllLeft(root, stack);
		}

		private void pushAllLeft(TNode root, Stack<TNode> stack) {
			while (null != root) {
				stack.push(root);
				root = root.left;
			}
		}

		public int next() {
			TNode node = stack.pop();
			pushAllLeft(node.right, stack);
			return node.data;
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}
	}

	// time complexity of next function in O(1)
	// space complexity O(n)
	private static void type1() {
		TNode root = TNode.makeBST(31);
		BstIterator1 bstIterator = new BstIterator1(root);
		while (bstIterator.hasNext()) {
			System.out.print(bstIterator.next() + " ");
		}
		System.out.println();
	}

	public static class BstIterator1 {
		private List<Integer> inorder;
		private int index;

		public BstIterator1(TNode root) {
			inorder = new ArrayList<>();
			index = 0;
			build(root);
		}

		private void build(TNode node) {
			if (node == null)
				return;
			build(node.left);
			inorder.add(node.data);
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
