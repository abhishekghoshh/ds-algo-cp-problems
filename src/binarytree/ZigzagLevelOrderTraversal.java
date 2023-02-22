package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;
/*
 * Problem link :
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=3OXWEdlIGl4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=20
 * 
 * https://takeuforward.org/data-structure/zig-zag-traversal-of-binary-tree/
 */

public class ZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// rather than using array list we can also use linked list and add the item
	// either first or last based on the flag
	private static void type3() {
		TreeNode<Integer> root = TreeNode.withCount(15);
		List<List<Integer>> zigzagTraversal = new ArrayList<>();
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		boolean flag = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			LinkedList<Integer> oneLevel = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				TreeNode<Integer> node = queue.poll();
				if (!flag)
					oneLevel.addLast(node.val);
				else
					oneLevel.addFirst(node.val);
				if (null != node.left)
					queue.offer(node.left);
				if (null != node.right)
					queue.offer(node.right);
			}
			flag = !flag;
			zigzagTraversal.add(oneLevel);
		}
		System.out.println(zigzagTraversal);
	}

	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(15);
		List<List<Integer>> answer = new ArrayList<>();
		traverse(root, answer, 0);
	}

	private static void traverse(TreeNode<Integer> curr, List<List<Integer>> sol, int level) {
		if (curr == null)
			return;
		if (sol.size() <= level) {
			List<Integer> newLevel = new LinkedList<>();
			sol.add(newLevel);
		}
		List<Integer> collection = sol.get(level);
		if (level % 2 == 0)
			collection.add(curr.val);
		else
			collection.add(0, curr.val);
		traverse(curr.left, sol, level + 1);
		traverse(curr.right, sol, level + 1);
	}

	// zigzag traversal means for one level the list is normal and for second level
	// the list is reversed
	// so we can set a flag and topple it every time
	// and based on it we can reverse the one level
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(15);
		List<List<Integer>> zigzagTraversal = new ArrayList<>();
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		boolean flag = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> oneLevel = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode<Integer> node = queue.poll();
				oneLevel.add(node.val);
				if (null != node.left)
					queue.offer(node.left);
				if (null != node.right)
					queue.offer(node.right);
			}
			if (flag)
				reverse(oneLevel);
			flag = !flag;
			zigzagTraversal.add(oneLevel);
		}
		System.out.println(zigzagTraversal);
	}

	private static void reverse(List<Integer> oneLevel) {
		int size = oneLevel.size();
		for (int i = 0; i < size / 2; i++) {
			int x = oneLevel.get(i);
			int y = oneLevel.get(size - i - 1);
			oneLevel.set(i, y);
			oneLevel.set(size - i - 1, x);
		}
	}

}
