package recursion;

import java.util.Stack;
/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/reverse-stack-using-recursion_631875
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=8YXQ68oHjAs&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=9
 * 
 * */
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
		insertAtBottom(stack, item);
	}

	private static void insertAtBottom(Stack<Integer> stack, int item) {
		if (stack.isEmpty()) {
			stack.push(item);
			return;
		}
		int lastItem = stack.pop();
		insertAtBottom(stack, item);
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
