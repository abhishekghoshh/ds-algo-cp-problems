package problems.others;

import java.util.HashMap;
import java.util.Map;

public class LFUCache<T, R> {
	private int size = 0;
	private final int capacity;
	private int leastFrequency = 1;
	Map<Integer, LRUCache<T, R>> frequencyMap;
	Map<T, Node<T, R>> cache;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		frequencyMap = new HashMap<>();
		cache = new HashMap<>();
	}

	public R get(T key) {
		if (cache.containsKey(key)) {
			Node<T, R> node = cache.get(key);
			updateFrequencyAndAdd(node);
		}
		return null;
	}

	private void updateFrequencyAndAdd(Node<T, R> node) {
		frequencyMap.get(node.frequency).remove(node);
		if (frequencyMap.get(node.frequency).isEmpty()) {
			frequencyMap.remove(node.frequency);
			leastFrequency = node.frequency + 1;
		}
		node.frequency++;
		if (!frequencyMap.containsKey(node.frequency)) {
			frequencyMap.put(node.frequency, new LRUCache<>());
		}
		frequencyMap.get(node.frequency).put(node);
	}

	public void put(T key, R value) {
		if (cache.containsKey(key)) {
			Node<T, R> node = cache.get(key);
			node.value(value);
			updateFrequencyAndAdd(node);
		} else {
			if (size == capacity) {
				frequencyMap.get(leastFrequency).removeTail();
				if (frequencyMap.get(leastFrequency).isEmpty()) {
					frequencyMap.remove(leastFrequency);
				}
				size--;
			}
			size++;
			leastFrequency = 1;
			Node<T, R> node = new Node<>(key, value, 1);
			if (!frequencyMap.containsKey(node.frequency)) {
				frequencyMap.put(node.frequency, new LRUCache<>());
			}
			frequencyMap.get(node.frequency).put(node);
		}
	}

	public static class LRUCache<T, R> {
		private int size = 0;
		private Node<T, R> head;
		private Node<T, R> tail;

		public LRUCache() {
			head = new Node<>();
			tail = new Node<>();
			head.next(tail);
			tail.prev(head);
		}

		public void put(Node<T, R> node) {
			size++;
			Node<T, R> next = head.next;
			node.next = next;
			node.prev = head;
			head.next = node;
			next.prev = node;
		}

		public void remove(Node<T, R> node) {
			size--;
			Node<T, R> prev = node.prev;
			prev.next = node.next;
			node.next.prev = prev;
		}

		public void removeTail() {
			remove(tail.prev);
		}

		public boolean isEmpty() {
			return size == 0;
		}
	}

	public static class Node<T, R> {
		private T key;
		R value;
		int frequency;
		Node<T, R> prev;
		Node<T, R> next;

		public Node(T key, R value, int frequency) {
			this.frequency = frequency;
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = null;
		}

		public Node() {
			this(null, null, 0);
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

	}

}
