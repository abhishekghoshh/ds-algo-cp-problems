package binarytree;

import java.util.Arrays;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * https://practice.geeksforgeeks.org/problems/preorder-to-postorder4423/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=UmJT3j26t1I&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=49
 * 
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

	public static void main(String[] args) {
		type0();
		type1();
		type2();
		type3();
	}

	private static void type3() {
		int[] preorder = { 8, 5, 1, 7, 10, 12 };
		TreeNode<Integer> root = makeBSTfromPreorder(preorder, Integer.MAX_VALUE, new int[] { 0 });
		System.out.println(root.preOrder());
	}

	// here also we are using the same but here we are calculating the index and
	// using the parent node value and upper bound
	// if the value is more than the root that means this is right subtree
	// check striver solution if you are unable to get this solution
	private static TreeNode<Integer> makeBSTfromPreorder(int[] preorder, int bound, int[] index) {
		if (index[0] == preorder.length || preorder[index[0]] > bound)
			return null;
		TreeNode<Integer> root = new TreeNode<>(preorder[index[0]++]);
		root.left = makeBSTfromPreorder(preorder, root.val, index);
		root.right = makeBSTfromPreorder(preorder, bound, index);
		return root;
	}

	// same as previous type
	// but here we are pre computing the next greater element in O(2n) time
	// in final make bst function we can just use the next greater element array
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

	// we know that for a preorder the sequence is root - left - right
	// for a bst left < root < right
	// now we can make some assumptions like
	// so the first element is root in the sequence
	// and the right higher element for root will be the starting of right subtree
	// and starting index + 1 to higher element index - 1 will be the left subtree
	// now we can make a recursive call on array
	private static TreeNode<Integer> bstFromPreorder(int[] preorder, int start, int end) {
		if (start == end)
			return new TreeNode<>(preorder[start]);
		else if (start > end || start < 0 || end >= preorder.length)
			return null;
		else {
			TreeNode<Integer> root = new TreeNode<>(preorder[start]);
			int mid = start + 1;
			// finding the right higher value index
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

	private static void type0() {
		int[] preorder = { 8, 5, 1, 7, 10, 12 };
		int[] inOrder = new int[preorder.length];
		for (int i = 0; i < preorder.length; i++)
			inOrder[i] = preorder[i];
		Arrays.sort(inOrder);
		// now we have inorder as well as preorder traversal so we can make unique tree
	}

}
