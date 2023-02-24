package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * https://practice.geeksforgeeks.org/problems/preorder-to-postorder4423/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=UmJT3j26t1I&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=50
 * 
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {
		int[] preorder = { 8, 5, 1, 7, 10, 12 };
		TreeNode<Integer> root = bstUtil(preorder, Integer.MAX_VALUE, new int[] { 0 });
		System.out.println(root.preOrder());
	}

	private static TreeNode<Integer> bstUtil(int[] preorder, int bound, int[] index) {
		if (index[0] == preorder.length || preorder[index[0]] > bound)
			return null;
		TreeNode<Integer> root = new TreeNode<>(preorder[index[0]++]);
		root.left = bstUtil(preorder, root.val, index);
		root.right = bstUtil(preorder, bound, index);
		return root;
	}

	private static void type2() {
		int[] preorder = { 8, 5, 1, 7, 10, 12 };
		TreeNode<Integer> root = bstFromPreorder(preorder, nextGreaterIndex(preorder), 0, preorder.length - 1);
		System.out.println(root.preOrder());
	}

	public static int[] nextGreaterIndex(int[] preorder) {
		int n = preorder.length;
		int[] nextGreaterIndex = new int[n];
		int[] stack = new int[n];
		int top = -1;
		for (int i = n - 1; i >= 0; i--) {
			while (top != -1 && preorder[i] >= preorder[stack[top]])
				top--;
			if (top == -1)
				nextGreaterIndex[i] = n;
			else
				nextGreaterIndex[i] = stack[top];
			stack[++top] = i;
		}
		return nextGreaterIndex;
	}

	public static TreeNode<Integer> bstFromPreorder(int[] preorder, int[] nextGreaterIndex, int start, int end) {
		if (start == end) {
			return new TreeNode<>(preorder[start]);
		} else if (start > end || start < 0 || end >= preorder.length) {
			return null;
		} else {
			int mid = nextGreaterIndex[start];
			TreeNode<Integer> root = new TreeNode<>(preorder[start]);
			root.left = bstFromPreorder(preorder, nextGreaterIndex, start + 1, mid - 1);
			root.right = bstFromPreorder(preorder, nextGreaterIndex, mid, end);
			return root;
		}
	}

	private static void type1() {
		int[] preorder = { 8, 5, 1, 7, 10, 12 };
		TreeNode<Integer> root = bstFromPreorder(preorder, 0, preorder.length - 1);
		System.out.println(root.preOrder());
	}

	private static TreeNode<Integer> bstFromPreorder(int[] preorder, int start, int end) {
		if (start == end)
			return new TreeNode<>(preorder[start]);
		else if (start > end || start < 0 || end >= preorder.length)
			return null;
		else {
			TreeNode<Integer> root = new TreeNode<>(preorder[start]);
			int mid = start + 1;
			while (mid <= end) {
				if (preorder[mid] > root.val)
					break;
				mid++;
			}
			root.left = bstFromPreorder(preorder, start + 1, mid - 1);
			root.right = bstFromPreorder(preorder, mid, end);
			return root;
		}
	}

}
