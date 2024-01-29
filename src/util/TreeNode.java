package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode<T extends Comparable<T>> {
	public T val;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode<T> parent;
	int count = 1;

	public TreeNode() {
	}

	public TreeNode(T val) {
		this.val = val;
	}

	public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public TreeNode(T val, TreeNode<T> left, TreeNode<T> right, TreeNode<T> parent) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	public T getVal() {
		return val;
	}

	public T val() {
		return this.getVal();
	}

	public void setVal(T val) {
		this.val = val;
	}

	public TreeNode<T> val(T val) {
		this.setVal(val);
		return this;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public TreeNode<T> left() {
		return this.getLeft();
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> left(TreeNode<T> left) {
		this.setLeft(left);
		return this;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public TreeNode<T> right() {
		return this.getRight();
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public TreeNode<T> right(TreeNode<T> right) {
		this.setRight(right);
		return this;
	}

	public TreeNode<T> search(T val) {
		if (val == this.val)
			return this;
		TreeNode<T> leftSearch = null, rightSearch = null;
		if (null != this.left)
			leftSearch = this.left.search(val);
		if (null != leftSearch)
			return leftSearch;
		if (null != this.right)
			rightSearch = this.right.search(val);
        return rightSearch;
    }

	public static TreeNode<Integer> withCount(int count) {
		Integer[] array = new Integer[count];
		for (int i = 1; i <= count; i++) {
			array[i - 1] = i;
		}
		return withAllNodesGiven(array);
	}

	public static TreeNode<Integer> makeBST(int count) {
		Integer[] array = new Integer[count];
		for (int i = 1; i <= count; i++) {
			array[i - 1] = i;
		}
		return makeBST(array, 0, count - 1);
	}

	public static <T extends Comparable<T>> TreeNode<T> makeBST(T[] array) {
		Arrays.sort(array);
		return makeBST(array, 0, array.length - 1);
	}

	private static <T extends Comparable<T>> TreeNode<T> makeBST(T[] array, int leftBound, int rightBound) {
		if (leftBound == rightBound)
			return new TreeNode<>(array[leftBound]);
		if (leftBound >= 0 && leftBound < array.length && rightBound >= 0 && rightBound < array.length
				&& leftBound < rightBound) {
			int mid = (leftBound + rightBound) / 2;
			TreeNode<T> root = new TreeNode<>(array[mid]);
			root.left = makeBST(array, leftBound, mid - 1);
			root.right = makeBST(array, mid + 1, rightBound);
			return root;
		}
		return null;
	}

	public TreeNode<T> searchBST(T val) {
		return searchBST(this, val);
	}

	public static <T extends Comparable<T>> TreeNode<T> searchBST(TreeNode<T> root, T val) {
		if (null == root || root.val == val)
			return root;
		return val.compareTo(root.val) < 1 ? searchBST(root.left, val) : searchBST(root.right, val);
	}

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> TreeNode<T> withAllNodesGiven(T... array) {
		TreeNode<T>[] nodes = (TreeNode<T>[]) new TreeNode[array.length];
		for (int i = 0; i < array.length; i++) {
			if (null != array[i]) {
				nodes[i] = new TreeNode<T>(array[i]);
			} else {
				nodes[i] = null;
			}

		}
		TreeNode<T> root = nodes[0];
		for (int i = 0; i < array.length; i++) {
			if (null != nodes[i]) {
				if (i * 2 + 1 < array.length && null != nodes[i * 2 + 1]) {
					nodes[i].left = nodes[i * 2 + 1];
				}
				if (i * 2 + 2 < array.length && null != nodes[i * 2 + 2]) {
					nodes[i].right = nodes[i * 2 + 2];
				}
			}
		}
		return root;
	}

	@Override
	public String toString() {
		return "[val=" + val + ", left=" + (null == left ? "null" : left.val) + ", right="
				+ (null == right ? "null" : right.val) + "]";
	}

	public List<T> inOrder() {
		return inOrder(this, new ArrayList<>());
	}

	public static <T extends Comparable<T>> List<T> inOrder(TreeNode<T> curr, List<T> list) {
		if (curr != null) {
			inOrder(curr.left, list);
			list.add(curr.val);
			inOrder(curr.right, list);
		}
		return list;
	}

	public List<T> preOrder() {
		return preOrder(this, new ArrayList<>());
	}

	public static <T extends Comparable<T>> List<T> preOrder(TreeNode<T> curr, List<T> list) {
		if (curr != null) {
			list.add(curr.val);
			preOrder(curr.left, list);
			preOrder(curr.right, list);
		}
		return list;
	}

	public List<T> postOrder() {
		return postOrder(this, new ArrayList<>());
	}

	public static <T extends Comparable<T>> List<T> postOrder(TreeNode<T> curr, List<T> list) {
		if (curr != null) {
			postOrder(curr.left, list);
			postOrder(curr.right, list);
			list.add(curr.val);
		}
		return list;
	}

	public List<List<T>> levelOrder() {
		return levelOrder(this);
	}

	public static <T extends Comparable<T>> List<List<T>> levelOrder(TreeNode<T> root) {
		Queue<TreeNode<T>> queue = new LinkedList<>();
		List<List<T>> wrapList = new LinkedList<List<T>>();
		if (root == null)
			return wrapList;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<T> subList = new LinkedList<>();
			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				subList.add(queue.poll().val);
			}
			wrapList.add(subList);
		}
		return wrapList;
	}
}
