package binarytree;

import com.algo.binarytree.TNode;

/*
 * Problem link :
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 * https://practice.geeksforgeeks.org/problems/search-a-node-in-bst/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=KcNt6v_56cc&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=41
 * 
 * 
 */
public class SearchInBinarySearchTree {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		TNode root = TNode.makeBST(15);
		TNode node = searchBST(root, 2);
		System.out.println(node);
		System.out.println(root.searchBST(2));
	}

	public static TNode searchBST(TNode root, int val) {
		if (null == root || root.data == val) return root;
		return val < root.data ?
				searchBST(root.left, val) :
				searchBST(root.right, val);
	}
}
