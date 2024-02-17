package com.ds.binarytree;

import com.algo.binarytree.TNode;
import com.util.PrintUtl;

import java.util.Stack;

/*
 * Problem link :
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * https://practice.geeksforgeeks.org/problems/flatten-binary-tree-to-linked-list/1
 * https://www.codingninjas.com/studio/problems/flatten-binary-tree-to-linked-list_1112615
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=sWf7k1x9XR4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=39
 * 
 * https://takeuforward.org/data-structure/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	private static void type5() {
		TNode root = TNode.withCount(15);
		flatten5(root);
		PrintUtl.preOrder(root);
	}

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
	public static TNode[] flatten5(TNode root) {
		if (null == root) return null;
		TNode last = root;
		TNode[] leftSideList = flatten5(root.left);
		TNode[] rightSideList = flatten5(root.right);
		if (null != leftSideList) {
			root.left = null;
			root.right = leftSideList[0];
			last = leftSideList[1];
		}
		if (null != rightSideList) {
			last.right = rightSideList[0];
			last = rightSideList[1];
		}
		return new TNode[]{root, last};
	}

	private static void type4() {
		TNode root = TNode.withCount(15);
		flatten4(root);
		PrintUtl.preOrder(root);
	}

	public static void flatten4(TNode root) {
		if (root == null) {
			return;
		}
		flatten4(root.right);
		flatten4(root.left);
		TNode last = root.right;
		root.right = root.left;
		root.left = null;
		while (root.right != null)
			root = root.right;
		root.right = last;
	}

	// morris traversal
	// check striver solution
	private static void type3() {
		TNode root = TNode.withCount(15);
		flatten3(root);
		PrintUtl.preOrder(root);
	}

	private static void flatten3(TNode root) {
		TNode curr = root;
		while (curr != null) {
			if (curr.left != null) {
				TNode prev = curr.left;
				while (prev.right != null) {
					prev = prev.right;
				}
				prev.right = curr.right;
				curr.right = curr.left;
				curr.left = null;
			}
			curr = curr.right;
		}
	}

	// same as a previous
	// iterative preorder
	// check striver solution
	private static void type2() {
		TNode root = TNode.withCount(15);
		flatten2(root);
		PrintUtl.preOrder(root);
	}

	private static void flatten2(TNode root) {
		if (root == null) return;
		Stack<TNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TNode current = stack.pop();
			if (current.right != null) stack.push(current.right);
			if (current.left != null) stack.push(current.left);
			if (!stack.isEmpty()) current.right = stack.peek();
			current.left = null;
		}
	}

	// check a striver solution
	// using reverse pre-order
	private static void type1() {
		TNode root = TNode.withCount(15);
		flatten1(root);
		PrintUtl.preOrder(root);
	}

	public static void flatten1(TNode root) {
		if (root == null) return;
		reversePostOrder(root);
	}

	private static TNode prev = null;

	private static void reversePostOrder(TNode root) {
		if (root == null) return;
		reversePostOrder(root.right);
		reversePostOrder(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}
}