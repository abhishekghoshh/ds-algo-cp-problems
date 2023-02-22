package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import util.TreeNode;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
 * https://www.codingninjas.com/codestudio/problems/799401
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=Et9OCDNvJ78&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=23
 * 
 * https://takeuforward.org/data-structure/top-view-of-a-binary-tree/
 */
public class TopViewOfBinaryTree {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// using bfs or level wise traversal
	// as we are doing the level wise, so we are sure that the top most level is
	// traversed first
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
			if (!map.containsKey(axis))
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

	// Using DFS traversal
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(15);
		Map<Integer, Pair2> map = new HashMap<>();
		traverse(root, map, 0, 0);
		List<Integer> answer = new ArrayList<>();

		int minKey = Integer.MAX_VALUE;
		for (int key : map.keySet())
			if (minKey > key)
				minKey = key;
		while (map.containsKey(minKey))
			answer.add(map.get(minKey++).val);
		System.out.println(answer);

	}

	private static void traverse(TreeNode<Integer> root, Map<Integer, Pair2> map, int axis, int level) {
		if (null == root)
			return;
		// if axis is not present then we can directly store the value else we have
		// check that at which level the node was stored
		if (!map.containsKey(axis) || (map.containsKey(axis) && map.get(axis).level > level))
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
