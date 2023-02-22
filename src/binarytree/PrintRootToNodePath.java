package binarytree;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/*
 * Problem link :
 * https://www.interviewbit.com/problems/path-to-given-node/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=fmflMqVOC7k&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=27
 * 
 * https://takeuforward.org/data-structure/print-root-to-node-path-in-a-binary-tree/
 */
public class PrintRootToNodePath {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(100);
		int target = 56;
		ArrayList<Integer> list = new ArrayList<>();
		find(root, target, list);
		reverse(list);
		System.out.println(list);
	}

	private static boolean find(TreeNode<Integer> root, int target, List<Integer> list) {
		// if node is null then we are unable to find the target
		if (null == root)
			return false;
		// if current node is target or either in left subtree or right subtree we have
		// found the target then we will add the node to the current list and return
		// true
		if (root.val == target || (find(root.left, target, list) || find(root.right, target, list))) {
			list.add(root.val);
			return true;
		}
		// if we have not found the target then we will simply return false
		return false;
	}

	private static ArrayList<Integer> reverse(ArrayList<Integer> list) {
		int size = list.size();
		for (int i = 0; i < size / 2; i++) {
			int x = list.get(i);
			int y = list.get(size - i - 1);
			list.set(i, y);
			list.set(size - i - 1, x);
		}
		return list;
	}

}
