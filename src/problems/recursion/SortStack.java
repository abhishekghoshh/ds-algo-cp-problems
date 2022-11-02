package problems.recursion;

import java.util.Stack;

/*
 * Problem link : 
 * https://practice.geeksforgeeks.org/problems/sort-a-stack/1
 * https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=MOGBRkkOhkY&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=7
 * 
 * */

public class SortStack {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		Stack<Integer> stack = stack(5, 2, 7, 1, 6, 9, 8, 3, 4);
		sort(stack);
		System.out.println(stack);
	}

	private static void sort(Stack<Integer> stack) {
		// if there is no element then we will just return
		if (stack.isEmpty()) {
			return;
		}
		// the intuition is we will remove the last element
		// then sort the stack
		// then will place the last element to its exact position
		int lastItem = stack.pop();
		sort(stack);
		push(stack, lastItem);
	}

	private static void push(Stack<Integer> stack, int lastItem) {
		// if stack is empty so we can add the element
		// or top element of the stack is lesser than the item
		if (stack.isEmpty() || stack.peek() <= lastItem) {
			stack.add(lastItem);
		} else {
			// if the top element is bigger then we will pop the element again call the push
			// we are thinking that push will eventually push the item in its position
			// after placing the item then we are again pushing the last popped element
			int biggerElement = stack.pop();
			push(stack, lastItem);
			stack.push(biggerElement);
		}
	}

	private static Stack<Integer> stack(int... arr) {
		Stack<Integer> stack = new Stack<>();
		for (int item : arr) {
			stack.push(item);
		}
		return stack;
	}

}
