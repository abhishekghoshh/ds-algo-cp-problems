package com.ds.binarytree;

import com.algo.binarytree.TNode;
import com.util.PrintUtl;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link :
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * https://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1
 * https://www.codingninjas.com/studio/problems/construct-binary-tree-from-inorder-and-postorder-traversal_1266106
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=LgLRTaEMRVc&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=36
 * 
 * https://takeuforward.org/data-structure/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPostorder {

	public static void main(String[] args) {
		type1();
	}

	// recursively
	private static void type1() {
		int[] postorder = { 9, 15, 7, 20, 3 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		int n = postorder.length;
		Map<Integer, Integer> indices = new HashMap<>();
		for (int i = 0; i < n; i++)
			indices.put(inorder[i], i);
		TNode root = makeTree(postorder, indices, n - 1, 0, n - 1);
		PrintUtl.postOrder(root);
		PrintUtl.inOrder(root);
	}

	private static TNode makeTree(int[] postOrder, Map<Integer, Integer> indices, int pos, int start, int end) {
		if (start > end) return null;
		if (start == end) return new TNode(postOrder[pos]);
		int item = postOrder[pos];
		int inorderIndex = indices.get(item);
		int rightCount = end - inorderIndex;
		TNode left = makeTree(postOrder, indices, pos - rightCount - 1, start, inorderIndex - 1);
		TNode right = makeTree(postOrder, indices, pos - 1, inorderIndex + 1, end);
		return new TNode(item, left, right);
	}

}
