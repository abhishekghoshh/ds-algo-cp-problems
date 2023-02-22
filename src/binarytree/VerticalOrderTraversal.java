package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * https://www.codingninjas.com/codestudio/problems/vertical-order-traversal_920533
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=q_a6lpbKJdw&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=22
 * 
 * https://takeuforward.org/data-structure/vertical-order-traversal-of-binary-tree/
 */
public class VerticalOrderTraversal {

	public static void main(String[] args) {
		type1();
	}

	// we will do any dfs traversal and also keep track of the level and axis
	// and based on that we will store it in map and at last we will sort it and
	// store it in the final answer
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(1, 2, 3, 4, 6, 5, 7);
		Map<Integer, List<Pair>> map = new HashMap<>();
		verticalTraversal(root, map, 0, 0);
		int minKey = Integer.MAX_VALUE;
		for (int key : map.keySet())
			if (minKey > key)
				minKey = key;
		List<List<Integer>> answer = new ArrayList<>();
		// we have to add this condition as per the question
		Comparator<Pair> pairCondition = (p1, p2) -> {
			if (p1.level != p2.level)
				return Integer.compare(p1.level, p2.level);
			return Integer.compare(p1.val, p2.val);
		};
		while (map.containsKey(minKey)) {
			List<Pair> pairs = map.get(minKey);
			Collections.sort(pairs, pairCondition);
			List<Integer> list = new ArrayList<>();
			for (Pair p : pairs)
				list.add(p.val);
			answer.add(list);
			minKey++;
		}
		System.out.println(answer);
	}

	private static void verticalTraversal(TreeNode<Integer> root, Map<Integer, List<Pair>> map, int axis, int level) {
		if (null == root)
			return;
		if (!map.containsKey(axis))
			map.put(axis, new ArrayList<>());
		map.get(axis).add(new Pair(level, root.val));
		verticalTraversal(root.left, map, axis - 1, level + 1);
		verticalTraversal(root.right, map, axis + 1, level + 1);
	}

	public static class Pair {
		public int level;
		public int val;

		public Pair(int level, int val) {
			this.level = level;
			this.val = val;
		}

		@Override
		public String toString() {
			return "[" + level + "," + val + "]";
		}
	}
}
