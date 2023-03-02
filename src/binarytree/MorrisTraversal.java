package binarytree;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * https://practice.geeksforgeeks.org/problems/inorder-traversal/1
 * https://practice.geeksforgeeks.org/problems/preorder-traversal/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=80Zug6D1_r4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=38
 * 
 * https://takeuforward.org/data-structure/morris-inorder-traversal-of-a-binary-tree/
 * https://takeuforward.org/data-structure/morris-preorder-traversal-of-a-binary-tree/
 * 
 */
public class MorrisTraversal {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// preorder traversal without using any extra space
	// same as inorder but here we are adding the root at the first time when we are
	// seeing this, that means no link is not set yet
	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(15);
		System.out.println(root.preOrder());

		TreeNode<Integer> curr = root;

		List<Integer> answer = new ArrayList<>();
		while (null != curr) {
			if (null == curr.left) {
				answer.add(curr.val);
				curr = curr.right;
			} else {
				TreeNode<Integer> temp = curr.left;
				while (null != temp.right && temp.right != curr)
					temp = temp.right;
				if (temp.right == null) {
					temp.right = curr;
					answer.add(curr.val);
					curr = curr.left;
				} else {
					temp.right = null;
					curr = curr.right;
				}
			}
		}
		System.out.println(answer);
	}

	// inorder traversal without using any extra space
	// in order we know that after all the left node is completed then root node
	// will be traversed, the last node of left side will be the rightest node of
	// the left side, so we will create a link between righest node and the root
	// and if there is no left then we will directly add to list and go to right
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(15);
		System.out.println(root.inOrder());

		TreeNode<Integer> curr = root;

		List<Integer> answer = new ArrayList<>();
		while (null != curr) {
			// left is null
			if (null == curr.left) {
				answer.add(curr.val);
				curr = curr.right;
			} else {
				TreeNode<Integer> temp = curr.left;
				// we will go to righest node
				while (null != temp.right && temp.right != curr)
					temp = temp.right;
				// setting the link
				// then we will go to the left
				if (temp.right == null) {
					temp.right = curr;
					curr = curr.left;
				} else {
					// there was already a link
					// that means this is the second time we are in the root
					// so left part is traversed completely
					// we will now delete the link and add the root to list
					temp.right = null;
					answer.add(curr.val);
					curr = curr.right;
				}
			}
		}
		System.out.println(answer);
	}

}
