package binarytree;

import java.util.List;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/introduction-to-trees/1
 * https://practice.geeksforgeeks.org/problems/binary-tree-representation/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=_ANrF3FJm7I&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=2
 * https://www.youtube.com/watch?v=ctCpP0RFDFc&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=3
 * https://www.youtube.com/watch?v=hyLyW7rP24I&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=4
 *
 *
 * https://takeuforward.org/binary-tree/introduction-to-trees/
 * https://takeuforward.org/binary-tree/binary-tree-representation-in-c/
 * https://takeuforward.org/binary-tree/binary-tree-representation-in-java/
 */

public class IntroductionToBinaryTree {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		List<Integer> v = List.of(1, 2, 3, 4, 5, 6, 7);
		Node root0 = new Node(v.get(0));
		Node root1 = new Node(v.get(1));
		Node root2 = new Node(v.get(2));
		Node root3 = new Node(v.get(3));
		Node root4 = new Node(v.get(4));
		Node root5 = new Node(v.get(5));
		Node root6 = new Node(v.get(6));
		root0.left = root1;
		root0.right = root2;
		root1.left = root3;
		root1.right = root4;
		root2.left = root5;
		root2.right = root6;
	}

	public static class Node {
		int val;
		Node left, right;

		public Node(int val) {
			this.val = val;
		}
	}

	private static void type1() {
		// Given an integer i, the maximum number of nodes on level i of a binary tree.
		int n = 5;
		int maxNodes = 1 << (n - 1);
		System.out.println(maxNodes);

		// Types of binary tree
		// 1. Full binary tree
		// 2. Complete binary tree
		// 3. Perfect binary tree
		// 4. Balanced binary tree
		// 5. Degenerate tree
	}

}
