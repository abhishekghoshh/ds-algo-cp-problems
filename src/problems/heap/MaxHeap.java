package problems.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MaxHeap {

	public static class Heap {
		private int[] heap;
		private int size;
		private int maxsize;

		public Heap(int maxsize) {
			this.maxsize = maxsize;
			this.size = 0;
			heap = new int[this.maxsize];
		}

		public Heap(int[] array) {
			this.maxsize = array.length;
			this.size = array.length;
			this.heap = Arrays.copyOf(array, size);
			for (int i = this.maxsize / 2 - 1; i >= 0; i--) {
				maxHeapify(i);
			}
		}

		private int parent(int pos) {
			return (pos - 1) / 2;
		}

		private int leftChild(int pos) {
			return (2 * pos) + 1;
		}

		private int rightChild(int pos) {
			return (2 * pos) + 2;
		}

		private boolean isLeaf(int pos) {
			if (pos > (size / 2) - 1 && pos <= size) {
				return true;
			}
			return false;
		}

		private void swap(int fpos, int spos) {
			int tmp;
			tmp = heap[fpos];
			heap[fpos] = heap[spos];
			heap[spos] = tmp;
		}

		private void maxHeapify(int pos) {
			if (isLeaf(pos)) {
				return;
			}
			int highest = pos;
			if (leftChild(pos) < size && heap[pos] < heap[leftChild(pos)]) {
				highest = leftChild(pos);
			}
			if (leftChild(pos) < size && heap[pos] < heap[rightChild(pos)]) {
				highest = rightChild(pos);
			}
			if (highest != pos) {
				swap(pos, highest);
				maxHeapify(highest);
			}
		}

		public void insert(int element) {
			heap[size] = element;

			int current = size;
			while (heap[current] > heap[parent(current)]) {
				swap(current, parent(current));
				current = parent(current);
			}
			size++;
		}

		public int extractMax() {
			int popped = heap[0];
			heap[0] = heap[size - 1];
			size--;
			maxHeapify(0);
			return popped;
		}

		public int size() {
			return this.size;
		}

		public boolean isEmpty() {
			return this.size() != 0;
		}

		public void print() {
			for (int i = 0; i < size / 2; i++) {
				System.out.print("Parent LinkedListNode : " + heap[i]);
				if (leftChild(i) < size) {
					System.out.print(" Left Child : " + heap[leftChild(i)]);
				}
				if (rightChild(i) < size) {
					System.out.print(" Right Child : " + heap[rightChild(i)]);
				}
				System.out.println(); // for new line
			}
		}

	}

	public static void main(String[] args) {
		// usingPriorityQueue();
		// usingArray();
	}

	public static void usingArray() {
		int[] array = { 10, 5, 7, 30, 9 };
		MaxHeap.Heap maxHeap = new MaxHeap.Heap(array);
		maxHeap.print();
		System.out.println("Head value using peek function: " + maxHeap.extractMax());
		System.out.println("Head value using peek function: " + maxHeap.extractMax());
		System.out.println("Head value using peek function: " + maxHeap.extractMax());
		maxHeap.insert(9);
		maxHeap.insert(10);
		maxHeap.insert(11);
		maxHeap.print();
		System.out.println("Head value using peek function: " + maxHeap.extractMax());
		System.out.println("Head value using peek function: " + maxHeap.extractMax());
	}

	public static void usingPriorityQueue() {
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());
		pQueue.add(10);
		pQueue.add(5);
		pQueue.add(7);
		pQueue.add(30);
		System.out.println("Head value using peek function: " + pQueue.peek());
		Iterator<Integer> itr = pQueue.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("poll value using poll function: " + pQueue.poll());
		pQueue.offer(15);
		System.out.println("Head value using peek function: " + pQueue.peek());
		System.out.println("remove value using remove function: " + pQueue.remove());
	}
}
