package binarytree;

import com.algo.binarytree.TNode;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
 * https://www.codingninjas.com/codestudio/problems/maximum-path-sum-between-two-leaves_794950?leftPanelTab=1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=ArNyupe-XH0&list=PL_z_8CaSLPWfxJPz2-YKqL9gXWdgrhvdn&index=5
 * 
 * https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
 * 
 * */
public class MaximumPathSumNodesBinaryTreeFromLeafNodes {

	public static void main(String[] args) {
		type1();
		type2();
	}


	private static void type2() {
		TNode root = TNode.withNodes(6, -9, -10);
		MaxPathSum maxPathSum = new MaxPathSum();
		maxPath(root, maxPathSum);
		System.out.println(maxPathSum.get());
	}

	// as we are taking from the leaf
	// so we can not discard any value
	private static int maxPath(TNode root, MaxPathSum maxPathSum) {
		// if this is null then it will return 0
		if (null == root)
			return 0;
		// if this is a leaf node then it will return the node value
		if (null == root.left && null == root.right) {
			return root.data;
		}
		int left = maxPath(root.left, maxPathSum);
		int right = maxPath(root.right, maxPathSum);

		if (null != root.left && null != root.right) {
			maxPathSum.value = Math.max(maxPathSum.value, root.data + left + right);
			return root.data + Math.max(left, right);
		} else {
			return root.data + (null != root.left ? left : right);
		}
	}

	static class MaxPathSum {
		public int value = Integer.MIN_VALUE;

		public int get() {
			return value != Integer.MIN_VALUE ? value : -1;
		}
	}

	private static void type1() {
	}
 
}
