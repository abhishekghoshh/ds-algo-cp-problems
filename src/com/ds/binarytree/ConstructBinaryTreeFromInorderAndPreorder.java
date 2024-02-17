package com.ds.binarytree;

import com.algo.binarytree.TNode;
import com.util.PrintUtl;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Problem link :
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * https://practice.geeksforgeeks.org/problems/construct-tree-1/1
 * https://www.codingninjas.com/studio/problems/construct-binary-tree-from-inorder-and-preorder-traversal_920539
 *
 * Solution link :
 * https://www.youtube.com/watch?v=aZNaLrVebKQ&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=35
 * 
 * https://takeuforward.org/data-structure/construct-a-binary-tree-from-inorder-and-preorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPreorder {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	// iterative way
	// we will main a stack of nodes to get the left most
	// TODO study it one more time
	private static void type4() {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };

		int n = preorder.length;
		Stack<TNode> stack = new Stack<>();
		// we are starting from the root node as 0th index of the preorder
		TNode root = new TNode(preorder[0]);
		TNode node = root;

		for (int preorderIndex = 1, inorderIndex = 0; preorderIndex < n; preorderIndex++) {
			//
			if (node.data != inorder[inorderIndex]) {
				// so we add the current node to the stack, assign the new node to its left,
				// and we go to the left subtree
				stack.push(node);
				node.left = new TNode(preorder[preorderIndex]);
				node = node.left;
			} else {
				inorderIndex++;
				while (!stack.empty() && stack.peek().data == inorder[inorderIndex]) {
					node = stack.pop();
					inorderIndex++;
				}
				node = node.right = new TNode(preorder[preorderIndex]);
			}
		}
		PrintUtl.preOrder(root);
		PrintUtl.inOrder(root);
	}


	// recursively
	// here we will maintain two index one for preOrder and one for inOrder
	// TODO study later one more time
	private static void type3() {
		int[] preorder = {3, 9, 20, 15, 7};
		int[] inorder = {9, 3, 15, 20, 7};
		// makeTree method will recursively create the tree
		TNode root = makeTree2(preorder, inorder, Integer.MIN_VALUE);
		PrintUtl.preOrder(root);
		PrintUtl.inOrder(root);
	}

	private static int inOrderIndex = 0;
	private static int preOrderIndex = 0;

	private static TNode makeTree2(int[] preorder, int[] inorder, int stop) {
		if (preOrderIndex >= preorder.length) return null;

		if (inorder[inOrderIndex] == stop) {
			++inOrderIndex;
			return null;
		}
		TNode node = new TNode(preorder[preOrderIndex++]);
		node.left = makeTree2(preorder, inorder, node.data);
		node.right = makeTree2(preorder, inorder, stop);
		return node;
	}


	private static void type2() {
		int[] preorder = {3, 9, 20, 15, 7};
		int[] inorder = {9, 3, 15, 20, 7};
		int n = preorder.length;
		// we are building a map to find the inOrder index in O(1)
		Map<Integer, Integer> inorderIndices = new HashMap<>();
		for (int i = 0; i < n; i++) inorderIndices.put(inorder[i], i);
		// makeTree method will recursively create the tree
		TNode root = makeTree1(preorder, inorderIndices, 0, n - 1);
		PrintUtl.preOrder(root);
		PrintUtl.inOrder(root);
	}


	static int preorderIndex = 0;

	private static TNode makeTree1(int[] preorder, Map<Integer, Integer> indices,
								   int inorderStart, int inorderEnd) {
		if (inorderStart > inorderEnd) return null;
		// if start and end are same, then it has only one node, so we can directly return that
		if (inorderStart == inorderEnd) return new TNode(preorder[preorderIndex++]);
		// first, we will find the root node from the post-order index
		// and decrement the post order index for the next right subtree
		int rootNode = preorder[preorderIndex++];
		int inorderRootIndex = indices.get(rootNode);
		TNode left = makeTree1(preorder, indices, inorderStart, inorderRootIndex - 1);
		// we have the left tree count, so we can easily construct the right tree recursion
		// preOrder root will be current preOrder root position + left subtree count + 1
		// as in the pre-order the sequence will be like root <- left <- right
		TNode right = makeTree1(preorder, indices, inorderRootIndex + 1, inorderEnd);
		return new TNode(rootNode, left, right);
	}

	// recursively
	// preorder and inorder consist of unique values.
	// so we can make a map to find the inorder index in O(1)
	// we will start from the preOrder because in preOrder we get the root node in 0th element,
	// then from that node we will get the left tree size and right tree size from the inOrder
	private static void type1() {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		int n = preorder.length;
		// we are building a map to find the inOrder index in O(1)
		Map<Integer, Integer> inorderIndices = new HashMap<>();
		for (int i = 0; i < n; i++) inorderIndices.put(inorder[i], i);
		// makeTree method will recursively create the tree
		TNode root = makeTree1(preorder, inorderIndices, 0, 0, n - 1);
		PrintUtl.preOrder(root);
		PrintUtl.inOrder(root);
	}


	// so we have to maintain three indices,
	// one for preOrder root position,
	// another from start node position of the inorder, and another is for end node position of the inorder.
	// first, we will get the root node value from the preOrder traversal
	private static TNode makeTree1(int[] preorder, Map<Integer, Integer> indices,
								   int preorderRootPos, int inorderStart, int inorderEnd) {
		if (inorderStart > inorderEnd) return null;
		// if start and end are same, then it has only one node, so we can directly return that
		if (inorderStart == inorderEnd) return new TNode(preorder[preorderRootPos]);
		// finding the root node value
		int rootNode = preorder[preorderRootPos];
		// from the map we are getting the node's position in the inorder traversal
		int inorderRootIndex = indices.get(rootNode);
		// we need at least one child node count
		int leftCount = inorderRootIndex - inorderStart;
		// again, we will recursively construct it's left and right child.
		// for the left tree preOrder root index will be (current preOrder root index + 1)
		// inorder start will be the same, but the ending node will be (current inorderRootIndex - 1)
		// because in inorder left tree will be previous to the root node
		TNode left = makeTree1(preorder, indices, preorderRootPos + 1, inorderStart, inorderRootIndex - 1);
		// we have the left tree count, so we can easily construct the right tree recursion
		// preOrder root will be current preOrder root position + left subtree count + 1
		// as in the pre-order the sequence will be like root <- left <- right
		TNode right = makeTree1(preorder, indices, preorderRootPos + leftCount + 1, inorderRootIndex + 1, inorderEnd);
		return new TNode(rootNode, left, right);
	}

}
