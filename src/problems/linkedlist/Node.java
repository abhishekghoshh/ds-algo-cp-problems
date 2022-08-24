package problems.linkedlist;

import java.util.*;

public class Node<T> {
	private List<Node<T>> holders = null;
	public T data;
	public Node<T> next;

	Node(T data) {
		this.data = data;
		this.next = null;
	}
	Node() {
		this.next = null;
	}

	@SafeVarargs
	Node(T... datas) {
		if (datas.length == 0) {
			throw new IllegalArgumentException("Atleast on data needed");
		}
		this.data = datas[0];
		Node<T> node = this;
		Node<T> newNode = null;
		for (int i = 1; i < datas.length; i++) {
			newNode = new Node<>(datas[i]);
			node.next = newNode;
			node = newNode;
		}
	}

	/**
	 * @return T return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return Node<T> return the next
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> next(Node<T> next) {
		if (null == this.holders) {
			this.holders = new ArrayList<>();
		}
		this.holders.add(next);
		return this;
	}

	// complete it
	// next without build method
	public Node<T> nextI(Node<T> next) {
		Node<T> curreNode = this;
		if (null != next) {

		}
		return this;
	}

	public Node<T> build() {
		if (null != this.holders) {
			Node<T> currentNode = getLastNode(this);
			for (Node<T> node : this.holders) {
				currentNode.next = node;
				Node<T> intermediateNode = node;
				while (intermediateNode.next != null) {
					intermediateNode = intermediateNode.next;
				}
				currentNode = intermediateNode;
			}
			this.holders = null;
		}
		return this;
	}

	private Node<T> getLastNode(Node<T> node) {
		while (null != node.next) {
			node = node.next;
		}
		return node;
	}

	public int getCount() {
		return count(this);
	}

	public static <T> int count(Node<T> node) {
		if (null == node)
			return 0;
		int count = 0;
		while (node.next != null) {
			node = node.next;
			count++;
		}
		return count;
	}

	@Override
	public String toString() {
		Node<T> node = this;
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		while (null != node) {
			if (null != node.next) {
				sb.append(node.data + ", ");
			}
			if (null == node.next) {
				sb.append(node.data);
			}
			node = node.next;
		}
		sb.append(" ]");
		return sb.toString();
	}

	public void print() {
		print(this);
	}

	public static <T> void print(Node<T> node) {
		System.out.println(node.toString());
	}

}
