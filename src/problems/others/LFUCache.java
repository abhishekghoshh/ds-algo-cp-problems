package problems.others;

import java.util.HashMap;
import java.util.Map;

public class LFUCache<T, R> {
	private int size = 0;
	private final int capacity;
	private int leastFrequency = 1;
	Map<Integer, LRUCache<T, R>> frequencyMap;
	Map<T, Node<T, R>> cache;

	public LFUCache() {
		this(3);
	}

	public LFUCache(int capacity) {
		this.capacity = capacity;
		frequencyMap = new HashMap<>();
		cache = new HashMap<>();
	}

	public R get(T key) {
		if (cache.containsKey(key)) {
			Node<T, R> node = cache.get(key);
			updateFrequencyAndAdd(node);
			return node.value();
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
				Node<T, R> last = frequencyMap.get(leastFrequency).removeTail();
				cache.remove(last.key());
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
			cache.put(key, node);
			frequencyMap.get(node.frequency).put(node);
		}
	}

	@Override
	public String toString() {
		return "LFUCache {size=" + size + ", capacity=" + capacity + ", frequencyMap=" + frequencyMap + "}";
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

		public Node<T, R> removeTail() {
			Node<T, R> node = tail.prev;
			remove(node);
			return node;
		}

		public boolean isEmpty() {
			return size == 0;
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
		LFUCache<Integer, String> cache = new LFUCache<>(3);
		cache.put(1, "Abhishek");
		cache.put(2, "Nasim Molla");
		System.out.println(cache);
		cache.put(3, "Bishal Mukherjee");
		System.out.println(cache);
		cache.put(1, "Abhishek Ghosh");
		System.out.println(cache);
		System.out.println(cache.get(2));
		System.out.println(cache);
		cache.put(4, "Abhishek Pal");
		cache.put(4, "Abhishek Pal");
		cache.put(1, "Abhishek Ghosh");
		System.out.println(cache);

//		LFUCache<Integer, Integer> cache = new LFUCache<>(3);
//		cache.put(1, 1);
//		cache.put(2, 2);
//		System.out.println(cache);
//		System.out.println(cache.get(1));
//		System.out.println(cache);
//		cache.put(3, 3);
//		System.out.println(cache);
//		System.out.println(cache.get(2));
//		cache.put(4, 4);
//		System.out.println(cache);
//		System.out.println(cache.get(1));
//		System.out.println(cache);
	}

}
