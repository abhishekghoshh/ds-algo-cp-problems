package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * https://www.codingninjas.com/codestudio/problems/841416
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=eD3tmO66aBA&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=15
 * 
 * https://takeuforward.org/data-structure/maximum-depth-of-a-binary-tree/
 */
public class MaximumDepthBinaryTree {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// level wise traversal using a queue
	// take a integer level variable and increment that in every iteration
	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(10);
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		int level = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode<Integer> node = queue.poll();
				if (null != node.left)
					queue.offer(node.left);
				if (null != node.right)
					queue.offer(node.right);
			}
			// if there is any node added in queue that means there will be a new level
			if (!queue.isEmpty())
				level++;
		}
		System.out.println(level);
	}

	// using recursion
	// it will use the recursion stack
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(10);
		int height = maxDepth(root);
		System.out.println(height);
	}

	public static int maxDepth(TreeNode<Integer> root) {
		if (null == root)
			return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

}
