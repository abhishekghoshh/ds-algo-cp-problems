package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=KSsk8AhdOZA&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=42
 * 
 * 
 */
public class CeilInBinarySearchTree {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.makeBST(new Integer[] { 2, 3, 4, 5, 6, 7, 9, 10, 11, 13, 14 });
//		System.out.println(root.inOrder());
		int ceil = Integer.MAX_VALUE;
		int key = 8;
		TreeNode<Integer> curr = root;
		while (null != curr) {
			if (curr.val == key) {
				ceil = key;
				break;
			} else if (key < curr.val) {
				ceil = curr.val;
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		System.out.println(ceil);
	}

}
