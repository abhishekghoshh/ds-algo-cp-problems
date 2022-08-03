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

	public Node<T> build() {
		if (null != this.holders) {
			Node<T> curreNode = this;
			for (Node<T> node : this.holders) {
				curreNode.next = node;
				Node<T> intermediateNode = node;
				while (intermediateNode.next != null) {
					intermediateNode = intermediateNode.next;
				}
				curreNode = intermediateNode;
			}
			this.holders = null;
		}
		return this;
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
		return "Node [data=" + data + ", holders=" + holders + ", next=" + next + "]";
	}

	public void print() {
		print(this);
	}

	public static <T> void print(Node<T> node) {
		while(null!=node) {
			System.out.println(node.data);
			node=node.next;
		}
	}

}
