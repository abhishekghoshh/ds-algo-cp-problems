package com.problems.binarysearchtree;

import com.ds.binarytree.TNode;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * https://www.codingninjas.com/studio/problems/kth-smallest-node-in-bst_920441
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=9TJYWh0adfk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=46
 *
 * https://takeuforward.org/data-structure/kth-largest-smallest-element-in-binary-search-tree/
 */
public class KthSmallestLargestElementInBinaryTree {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// TODO kth largest
	// we will visit the nodes from right to left
	// then we can skip the counting operation
	private static void type3() {
		TNode root = TNode.makeBST(15);
		int k = 6;
		Data data = new Data();
		inOrder2(root, k, data);
		System.out.println(data.data);
	}

	private static void inOrder2(TNode root, int k, Data data) {
		// if the count has already reached k then will go no more
		// we will return from here
		if (null == root || data.count >= k) return;
		inOrder2(root.right, k, data);
		// every time we visit a non-null node we will increment the counter
		data.count++;
		// if the count is k then we will set the answer
		if (data.count == k) {
			data.data = root.data;
			return;
		}
		inOrder2(root.left, k, data);
	}


	// TODO kth largest
	// kth largest means n-k+1 th smallest
	private static void type2() {
		TNode root = TNode.makeBST(15);
		int k = 6;
		Data data = new Data();
		int n = count(root);
		inOrder1(root, n - k + 1, data);
		System.out.println(data.data);
	}

	private static int count(TNode root) {
		if (null == root) return 0;
		return 1 + count(root.left) + count(root.right);
	}

	// TODO kth smallest
	// we know the inorder of bst will give us the sorted list
	// we will keep a counter, and when the counter is k then we will store the value
	// time complexity is O(k)
	private static void type1() {
		TNode root = TNode.makeBST(15);
		int k = 6;
		Data data = new Data();
		inOrder1(root, k, data);
		System.out.println(data.data);
	}

	private static void inOrder1(TNode root, int k, Data data) {
		// if the count has already reached k then will go no more
		// we will return from here
		if (null == root || data.count >= k) return;
		inOrder1(root.left, k, data);
		// every time we visit a non-null node we will increment the counter
		data.count++;
		// if the count is k then we will set the answer
		if (data.count == k) {
			data.data = root.data;
			return;
		}
		inOrder1(root.right, k, data);
	}

	static class Data {
		public int count = 0;
		public int data = Integer.MAX_VALUE;
	}

}
