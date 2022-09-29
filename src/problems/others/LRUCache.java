package problems.others;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache<T, R> {
	private Node<T, R> head;
	private Node<T, R> tail;
	private int capacity;
	private int size = 0;
	// We can also create an array in place of map if the key is integer and we know
	// the key range which is very good for leetcode but in real world scenario it
	// will not help and using generics may look over engineering but it will work
	// better if we have a dynamic key value pair based on situation
	Map<T, Node<T, R>> cache;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<>();
		head = new Node<>();
		tail = new Node<>();
		head.next(tail);
		tail.prev(head);
	}

	public R get(T key) {
		if (cache.containsKey(key)) {
			removeAndAddAfterHead(cache.get(key));
			return cache.get(key).value();
		}
		return null;
	}

	private void removeAndAddAfterHead(Node<T, R> node) {
		remove(node);
		add(this.head, node);
	}

	private void add(Node<T, R> head, Node<T, R> node) {
		Node<T, R> next = head.next;
		node.next = next;
		node.prev = head;
		head.next = node;
		next.prev = node;
	}

	private void remove(Node<T, R> node) {
		Node<T, R> prev = node.prev;
		prev.next = node.next;
		node.next.prev = prev;
	}

	public void put(T key, R value) {
		if (cache.containsKey(key)) {
			removeAndAddAfterHead(cache.get(key));
			cache.get(key).value(value);
		} else {
			if (size == capacity) {
				cache.remove(tail.prev.key());
				remove(tail.prev);
				size--;
			}
			size++;
			Node<T, R> node = new Node<>(key, value);
			add(this.head, node);
			cache.put(key, node);
		}
	}

	public String toString() {
		Node<T, R> node = head.next;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while (tail != node) {
			sb.append(node.value());
			node = node.next;
			if (tail != node) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public int capacity() {
		return capacity;
	}

	public int size() {
		return size;
	}

	public Set<T> keys() {
		return cache.keySet();
	}

	public static class Node<T, R> {
		private T key;
		R value;
		Node<T, R> prev;
		Node<T, R> next;

		public Node(T key, R value) {
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = null;
		}

		public Node() {
			this(null, null);
		}

		public T key() {
			return key;
		}

		public R value() {
			return value;
		}

		public Node<T, R> value(R value) {
			this.value = value;
			return this;
		}

		public Node<T, R> prev() {
			return prev;
		}

		public Node<T, R> prev(Node<T, R> prev) {
			this.prev = prev;
			return this;
		}

		public Node<T, R> next() {
			return next;
		}

		public Node<T, R> next(Node<T, R> next) {
			this.next = next;
			return this;
		}

	}

	public static void main(String[] args) {
//		LRUCache<Integer, String> cache = new LRUCache<>(3);
//		cache.put(1, "Abhishek");
//		cache.put(2, "Nasim Molla");
//		System.out.println(cache);
//		cache.put(3, "Bishal Mukherjee");
//		System.out.println(cache);
//		cache.put(1, "Abhishek Ghosh");
//		System.out.println(cache);
//		System.out.println(cache.get(2));
//		System.out.println(cache);
//		cache.put(4, "Abhishek Pal");
//		System.out.println(cache);

		LRUCache<Integer, Integer> cache = new LRUCache<>(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache);
		System.out.println(cache.get(1));
		System.out.println(cache);
		cache.put(3, 3);
		System.out.println(cache);
		System.out.println(cache.get(2));
		cache.put(4, 4);
		System.out.println(cache);
		System.out.println(cache.get(1));
	}
}
