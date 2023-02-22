package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import util.TreeNode;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
 * https://www.codingninjas.com/codestudio/problems/893110
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=0FtVY6I4pB8&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=24
 * 
 * https://takeuforward.org/data-structure/bottom-view-of-a-binary-tree/
 */
public class BottomViewOfBinaryTree {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// using BFS or level wise traversal
	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(15);
		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null)
			return;
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(root, 0));
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int axis = pair.axis;
			TreeNode<Integer> node = pair.node;
			// if there is any value for that axis then that will be replaced by the later
			// level
			map.put(axis, node.val);
			if (node.left != null)
				queue.add(new Pair(node.left, axis - 1));
			if (node.right != null)
				queue.add(new Pair(node.right, axis + 1));
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			ans.add(entry.getValue());
		}
		System.out.println(ans);
	}

	public static class Pair {
		public int axis;
		public TreeNode<Integer> node;

		public Pair(TreeNode<Integer> node, int axis) {
			this.axis = axis;
			this.node = node;
		}
	}

	// using DFS
	// almost same as top view
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(15);
		Map<Integer, Pair2> map = new HashMap<>();
		traverse(root, map, 0, 0);
		int minKey = Integer.MAX_VALUE;
		for (int key : map.keySet())
			if (minKey > key)
				minKey = key;
		ArrayList<Integer> answer = new ArrayList<>();
		while (map.containsKey(minKey))
			answer.add(map.get(minKey++).val);
		System.out.println(answer);
	}

	private static void traverse(TreeNode<Integer> root, Map<Integer, Pair2> map, int axis, int level) {
		if (null == root)
			return;
//		map.put(axis, new Pair2(root.val, level));
		// just the opposite condition of topview
		if (!map.containsKey(axis) || (map.containsKey(axis) && map.get(axis).level <= level))
			map.put(axis, new Pair2(root.val, level));
		traverse(root.left, map, axis - 1, level + 1);
		traverse(root.right, map, axis + 1, level + 1);
	}

	public static class Pair2 {
		public int level;
		public int val;

		public Pair2(int val, int level) {
			super();
			this.level = level;
			this.val = val;
		}
	}
}
