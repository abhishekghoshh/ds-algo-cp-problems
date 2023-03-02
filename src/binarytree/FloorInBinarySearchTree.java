package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/floor-in-bst/1
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=xm_W1ub-K-w&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=43
 * 
 * 
 */
public class FloorInBinarySearchTree {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.makeBST(new Integer[] { 2, 3, 4, 5, 6, 7, 9, 10, 11, 13, 14 });
		int floor = Integer.MIN_VALUE;
		int key = 8;
		TreeNode<Integer> curr = root;
		while (null != curr) {
			if (curr.val == key) {
				floor = key;
				break;
			} else if (key < curr.val) {
				curr = curr.left;
			} else {
				floor = curr.val;
				curr = curr.right;
			}
		}
		System.out.println(floor);
	}

}
