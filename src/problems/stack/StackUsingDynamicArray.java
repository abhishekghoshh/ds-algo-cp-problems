package problems.stack;

import java.util.ArrayList;
import java.util.List;

public class StackUsingDynamicArray<T> {
	private static final int DEFAULT_CAPACITY = 100;
	private List<T> array;
	private int size = 0;

	StackUsingDynamicArray() {
		this(DEFAULT_CAPACITY);
	}

	StackUsingDynamicArray(int initialCapacity) {
		this.array = new ArrayList<>(initialCapacity);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void push(T item) {
		size++;
		array.add(item);
	}

	public T pop() {
		if (size == 0) {
			throw new UnsupportedOperationException("No element present for popping");
		}
		return array.remove(--size);
	}

	public T peek() {
		if (size == 0) {
			throw new UnsupportedOperationException("No element present for peeking");
		}
		return array.get(size - 1);
	}

	public static void main(String[] args) {
		StackUsingDynamicArray<Integer> stack = new StackUsingDynamicArray<>(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		printException(() -> stack.push(4));
		System.out.println(stack.peek() + " " + stack.pop());
		System.out.println(stack.peek() + " " + stack.pop());
		System.out.println(stack.peek() + " " + stack.pop());
		System.out.println(stack.peek() + " " + stack.pop());
		printException(() -> System.out.println(stack.peek()));
		printException(() -> System.out.println(stack.pop()));
	}

	private static void printException(Runnable runnable) {
		try {
			runnable.run();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
