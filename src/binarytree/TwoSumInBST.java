package binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=ssL3sHwPeb4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=52
 * 
 * 
 */
public class TwoSumInBST {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// so rather than storing the whole list we can iterate once from front and once
	// from back and meanwhile we can calculate
	// we know how to iterate a BST, so we can similarly derive how can we iterate
	// list from back
	private static void type2() {
		TreeNode<Integer> root = TreeNode.makeBST(15);
		int k = 25;
		BSTIterator forwardIterator = new BSTIterator(root, true);
		BSTIterator backwardIterator = new BSTIterator(root, false);
		boolean hasTwoSum = false;
		for (int start = forwardIterator.next(), end = backwardIterator.next(); start < end;) {
			int sum = start + end;
			if (sum == k) {
				hasTwoSum = true;
				break;
			}
			if (sum < k)
				start = forwardIterator.next();
			else
				end = backwardIterator.next();
		}
		System.out.println(hasTwoSum);
	}

	private static class BSTIterator {
		private Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
		private boolean isForward;

		public BSTIterator(TreeNode<Integer> root, boolean isForward) {
			this.isForward = isForward;
			push(root);
		}

		public int next() {
			TreeNode<Integer> root = stack.pop();
			push(isForward ? root.right : root.left);
			return root.val;
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}

		private void push(TreeNode<Integer> root) {
			while (root != null) {
				stack.push(root);
				root = isForward ? root.left : root.right;
			}
		}
	}

	// this is similar to two sum problem in array
	// so we can store the inorder traversal in a list
	// which will be sorted
	// and then we can apply same two sum problem in the inorder list
	private static void type1() {
		TreeNode<Integer> root = TreeNode.makeBST(15);
		int k = 25;
		List<Integer> inorder = new ArrayList<>();
		inorder(root, inorder);
		int start = 0, end = inorder.size() - 1;
		boolean hasTwoSum = false;
		while (start < end) {
			int sum = inorder.get(start) + inorder.get(end);
			if (sum > k)
				end--;
			else if (sum < k)
				start++;
			else {
				hasTwoSum = true;
				break;
			}
		}
		System.out.println(hasTwoSum);
	}

	private static void inorder(TreeNode<Integer> root, List<Integer> inorder) {
		if (null == root)
			return;
		inorder(root.left, inorder);
		inorder.add(root.val);
		inorder(root.right, inorder);
	}

}
