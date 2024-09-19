package com.problems.binarytree;

import com.ds.binarytree.TNode;
import com.util.PrintUtl;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link :
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * https://www.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1
 * https://www.naukri.com/code360/problems/construct-binary-tree-from-inorder-and-postorder-traversal_1266106
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=LgLRTaEMRVc&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=36
 * 
 * https://takeuforward.org/data-structure/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPostorder {

	public static void main(String[] args) {
		type1();
		type2();
	}


	static int postOrderIndex = 0;

	// The intuition is if we go root then right and left,
	// so we don't have to pass the post-order position variable in the recursion.
	// We can just make the global postOrder Index.Every time we hit a node.
	// We just decrement the index, and the index will be root node of the right subtree
	// that is why we will build the root then right subtree then left subtree
	private static void type2() {
		int[] postorder = {9, 15, 7, 20, 3};
		int[] inorder = {9, 3, 15, 20, 7};
		int n = postorder.length;
		postOrderIndex = n - 1;
		// we are building a map to find the inOrder index in O(1)
		Map<Integer, Integer> indices = new HashMap<>();
		for (int i = 0; i < n; i++) indices.put(inorder[i], i);
		TNode root = makeTree2(postorder, indices, 0, n - 1);
		PrintUtl.postOrder(root);
		PrintUtl.inOrder(root);
	}

	static TNode makeTree2(int[] postorder, Map<Integer, Integer> indices,
						   int inorderStart, int inorderEnd) {
		if (inorderStart > inorderEnd) return null;
		// if start and end are same, then it has only one node, so we can directly return that
		if (inorderStart == inorderEnd) return new TNode(postorder[postOrderIndex--]);
		// first, we will find the root node from the post-order index
		// and decrement the post order index for the next right subtree
		int rootNode = postorder[postOrderIndex--];
		TNode root = new TNode(rootNode);
		int inorderRootPos = indices.get(rootNode);
		// for the post-order we will first go to right child first then the left child
		// because the post-order sequence is left <- right <- root
		root.right = makeTree2(postorder, indices, inorderRootPos + 1, inorderEnd);
		root.left = makeTree2(postorder, indices, inorderStart, inorderRootPos - 1);
		return root;
	}

	// recursively
	// postorder and inorder consist of unique values.
	// so we can make a map to find the inorder index in O(1)
	// we will start from the preOrder because in preOrder we get the root node in 0th element,
	// then from that node we will get the left tree size and right tree size from the inOrder
	private static void type1() {
		int[] postorder = { 9, 15, 7, 20, 3 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		int n = postorder.length;
		// we are building a map to find the inOrder index in O(1)
		Map<Integer, Integer> indices = new HashMap<>();
		for (int i = 0; i < n; i++) indices.put(inorder[i], i);
		TNode root = makeTree1(postorder, indices, n - 1, 0, n - 1);
		PrintUtl.postOrder(root);
		PrintUtl.inOrder(root);
	}

	private static TNode makeTree1(int[] postOrder, Map<Integer, Integer> indices,
								   int postorderPos, int inorderStart, int inorderEnd) {
		if (inorderStart > inorderEnd) return null;
		// if start and end are same, then it has only one node, so we can directly return that
		if (inorderStart == inorderEnd) return new TNode(postOrder[postorderPos]);
		// finding the root node value
		int rootNode = postOrder[postorderPos];
		// from the map we are getting the node's position in the inorder traversal
		int inorderIndex = indices.get(rootNode);
		// we need at least one child node count,
		int rightCount = inorderEnd - inorderIndex;
		// again, we will recursively construct it's left and right child.
		// here we will create the right subtree first.
		// for the right tree postorderPos root index will be (current postOrder root index + 1)
		// for the right subtree inorder start will be (current inorder root index + 1)
		// for the right subtree inorder end will be the same inorder end
		TNode right = makeTree1(postOrder, indices, postorderPos - 1, inorderIndex + 1, inorderEnd);
		// we have the right tree count, so we can easily construct the left tree recursion
		// postOrder root will be current postOrder root position - right subtree count - 1
		// as in the post-order the sequence will be like left <- right <- root
		TNode left = makeTree1(postOrder, indices, postorderPos - rightCount - 1, inorderStart, inorderIndex - 1);
		return new TNode(rootNode, left, right);
	}

}
