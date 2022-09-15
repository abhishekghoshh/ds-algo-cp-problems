package problems.recursion;

import java.util.Stack;

public class DeleteMiddleElementOfStack {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		Stack<Integer> stack = stack(5, 2, 7, 1, 6, 9, 8, 3, 4);
		// we will pass three parameter
		// stack, current index,stack size
		deleteMiddle(stack, stack.size(), stack.size());
		System.out.println(stack);
	}

	private static void deleteMiddle(Stack<Integer> stack, int current, int size) {
		// if current index == size/2 +1
		// so it is the element that we have to pop
		if (current == (size / 2) + 1) {
			stack.pop();
			return;
		}
		// we will first pop the last
		// and we will assume the function will delete the middle element
		// then we will again add the element
		int item = stack.pop();
		deleteMiddle(stack, current - 1, size);
		stack.push(item);
	}

	private static Stack<Integer> stack(int... arr) {
		Stack<Integer> stack = new Stack<>();
		for (int item : arr) {
			stack.push(item);
		}
		return stack;
	}

}
