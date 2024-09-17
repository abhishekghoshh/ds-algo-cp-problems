package com.problems.binarytree;

import com.ds.binarytree.TNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Problem link :
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * https://www.codingninjas.com/studio/problems/zigzag-binary-tree-traversal_920532
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=EoAsWbO7sqg&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=9
 * 
 * https://takeuforward.org/data-structure/level-order-traversal-of-a-binary-tree/
 */

public class LevelWiseOrderTraversal {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// recursively
	private static void type3() {
		TNode root = TNode.withCount(19);
		List<List<Integer>> levelWiseList = traverse(root, 0, new ArrayList<>());
		System.out.println(levelWiseList);
	}

	// we will also track a third variable to keep track of the current level
	// first it will go to the leftest node and while traversal.
	// It will add the list one by one, and in later part while traversing the right child, it will
	// get the level wise list and add the current node into that
	public static List<List<Integer>> traverse(TNode root, int level, List<List<Integer>> levelWiseList) {
		if (level == levelWiseList.size()) levelWiseList.add(new ArrayList<>());
		// add the root to its level
		levelWiseList.get(level).add(root.data);
		// traverse the left and right child with level+1
		if (root.left != null) traverse(root.left, level + 1, levelWiseList);
		if (root.right != null) traverse(root.right, level + 1, levelWiseList);
		return levelWiseList;
	}

	// iteratively
	private static void type2() {
		TNode root = TNode.withCount(19);
		Queue<TNode> queue = new LinkedList<>();
		List<List<Integer>> answer = new ArrayList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			// getting the current level size of the queue
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			// now add all the level data to list and add next level in the queue
			for (int i = 0; i < size; i++) {
				TNode node = queue.poll();
				level.add(node.data);
				if (null != node.left) queue.offer(node.left);
				if (null != node.right) queue.offer(node.right);
			}
			answer.add(level);
		}
		System.out.println(answer);
	}

	private static void type1() {
		TNode root = TNode.withCount(19);
		Queue<TNode> queue = new LinkedList<>();
		queue.offer(root);
		List<Integer> answer = new ArrayList<>();
		// polling from first every time
		// and will add its left and right child
		// so same level child will be in the there side by side
		while (!queue.isEmpty()) {
			TNode node = queue.poll();
			answer.add(node.data);
			if (null != node.left) queue.offer(node.left);
			if (null != node.right) queue.offer(node.right);
		}
		System.out.println(answer);
	}

}
