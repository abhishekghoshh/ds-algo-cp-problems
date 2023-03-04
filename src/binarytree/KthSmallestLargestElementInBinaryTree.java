package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=9TJYWh0adfk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=46
 * https://takeuforward.org/data-structure/kth-largest-smallest-element-in-binary-search-tree/
 * 
 * 
 */
public class KthSmallestLargestElementInBinaryTree {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// kth largest
	// kth largest means n-k+1 th smallest
	private static void type2() {
		TreeNode<Integer> root = TreeNode.makeBST(15);
		int k = 6;
		int[] pair = new int[] { 0, Integer.MAX_VALUE };
		int n = count(root);
		inOrder(root, n - k + 1, pair);
		System.out.println(pair[1]);
	}

	private static int count(TreeNode<Integer> root) {
		if (null == root)
			return 0;
		return 1 + count(root.left) + count(root.right);
	}

	// kth smallest
	// we know the inorder of bst will give us the sorted list
	// we will keep a counter and when the counter is k then we will store the value
	// time complexity is O(k)
	private static void type1() {
		TreeNode<Integer> root = TreeNode.makeBST(15);
		int k = 6;
		int[] pair = new int[] { 0, Integer.MAX_VALUE };
		inOrder(root, k, pair);
		System.out.println(pair[1]);
	}

	private static void inOrder(TreeNode<Integer> root, int k, int[] pair) {
		if (null == root)
			return;
		if (pair[0] < k) {
			inOrder(root.left, k, pair);
		}
		pair[0]++;
		if (pair[0] == k) {
			pair[1] = root.val;
			return;
		}
		if (pair[0] < k) {
			inOrder(root.right, k, pair);
		}
	}

}
