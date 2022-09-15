package problems.recursion;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		Stack<Integer> stack = stack(1, 2, 3, 4, 5, 6, 7, 8, 9);
		reverse(stack);
		System.out.println(stack);
	}

	private static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int item = stack.pop();
		reverse(stack);
		push(stack, item);
	}

	private static void push(Stack<Integer> stack, int item) {
		if (stack.isEmpty()) {
			stack.push(item);
			return;
		}
		int lastItem = stack.pop();
		push(stack, item);
		stack.push(lastItem);
	}

	private static Stack<Integer> stack(int... arr) {
		Stack<Integer> stack = new Stack<>();
		for (int item : arr) {
			stack.push(item);
		}
		return stack;
	}
}
