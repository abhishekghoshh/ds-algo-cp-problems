package binarytree;

import java.util.LinkedList;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 * https://practice.geeksforgeeks.org/problems/maximum-width-of-tree/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=ZbybYvcVLks&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=29
 * 
 * https://takeuforward.org/data-structure/maximum-width-of-a-binary-tree/
 */
public class MaximumWidthOfBinaryTree {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(15);
		LinkedList<Object[]> deque = new LinkedList<>();
		deque.add(new Object[] { root, 0 });
		int maxWidth = 1;
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				Object[] pair = deque.poll();
				@SuppressWarnings("unchecked")
				TreeNode<Integer> node = (TreeNode<Integer>) pair[0];
				int nodeNo = (int) pair[1];
				if (null != node.left)
					deque.offer(new Object[] { node.left, 2 * nodeNo + 1 });
				if (null != node.right)
					deque.offer(new Object[] { node.right, 2 * nodeNo + 2 });
			}
			if (deque.size() > 1)
				maxWidth = Math.max(maxWidth, (int) deque.getLast()[1] - (int) deque.getFirst()[1] + 1);
		}
		System.out.println(maxWidth);
	}

	// if we have to count only the non null node then we could just store the nodes
	// in queue and at last we can just take the size, but we have to also keep
	// track of the null nodes in between, so we will set numbers for each node and
	// in each level we will take the difference of the first node number to last
	// node number, the difference will tell us the nodes in between
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(15);
		LinkedList<Pair> deque = new LinkedList<>();
		deque.add(new Pair(root, 0));
		int maxWidth = 1;
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				Pair pair = deque.poll();
				int nodeNo = pair.nodeNo;
				TreeNode<Integer> node = pair.node;
				if (null != node.left)
					deque.offer(new Pair(node.left, 2 * nodeNo + 1));
				if (null != node.right)
					deque.offer(new Pair(node.right, 2 * nodeNo + 2));
			}
			if (deque.size() > 1)
				maxWidth = Math.max(maxWidth, deque.getLast().nodeNo - deque.getFirst().nodeNo + 1);
		}
		System.out.println(maxWidth);
	}

	public static class Pair {
		public TreeNode<Integer> node;
		public int nodeNo;

		public Pair(TreeNode<Integer> node, int nodeNo) {
			this.node = node;
			this.nodeNo = nodeNo;
		}

		@Override
		public String toString() {
			return "[" + node.val + "," + nodeNo + "]";
		}
	}
}
