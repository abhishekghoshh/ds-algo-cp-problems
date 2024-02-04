package binarytree;

import com.algo.binarytree.TNode;

/*
 * Problem link :
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 * 
 * Solution link :
 * 
 * 
 * */
public class SecondMinimumValueInBinaryTree {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		TNode root = new TNode(8)
				.left(new TNode(5))
				.right(new TNode(6));
		long[] data = { Long.MAX_VALUE, Long.MAX_VALUE };
		findSecondMinimumValue(root, data);
		int val = data[1] != Long.MAX_VALUE ? (int) data[1] : -1;
		System.out.println(val);
	}

	public static void findSecondMinimumValue(TNode root, long[] data) {
		if (null != root) {
			findSecondMinimumValue(root.left, data);
			if (root.data < data[0] && root.data < data[1]) {
				data[1] = data[0];
				data[0] = root.data;
			} else if (root.data > data[0] && root.data < data[1]) {
				data[1] = root.data;
			}
			findSecondMinimumValue(root.right, data);
		}
	}
}
