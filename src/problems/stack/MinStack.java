package problems.stack;

import java.util.Stack;

public class MinStack {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		MinStack2 stack = new MinStack2();
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(3);
		stack.push(3);
		System.out.println(stack);
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack);
	}

	public static class MinStack2 {
		private Stack<Integer> stack = new Stack<>();
		private Integer minElement;

		public Integer peek() {
			if (stack.size() == 0) {
				return -1;
			}
			return stack.peek();
		}

		public Integer min() {
			if (stack.size() == 0) {
				return -1;
			}
			return minElement;
		}

		public Integer pop() {
			if (stack.size() == 0) {
				return -1;
			}
			if (stack.peek() > minElement) {
				return stack.pop();
			} else {
				Integer tempMinElement = minElement;
				minElement = 2 * minElement - stack.peek();
				stack.pop();
				return tempMinElement;
			}
		}

		public void push(Integer item) {
			if (stack.size() == 0) {
				minElement = item;
				stack.add(item);
			} else if (item > minElement) {
				stack.add(item);
			} else {
				stack.add(2 * item - minElement);
				minElement = item;
			}
		}

		@Override
		public String toString() {
			return "stack " + stack + " \nminElement " + minElement;
		}
	}

	private static void type1() {
		MinStack1 minStackWithSpace = new MinStack1();
		minStackWithSpace.push(5);
		minStackWithSpace.push(6);
		minStackWithSpace.push(7);
		minStackWithSpace.push(3);
		minStackWithSpace.push(3);
		System.out.println(minStackWithSpace);
		minStackWithSpace.pop();
		minStackWithSpace.pop();
		minStackWithSpace.pop();
		System.out.println(minStackWithSpace);
	}

	public static class MinStack1 {
		private Stack<Integer> stack = new Stack<>();
		private Stack<Integer> minStack = new Stack<>();

		public Integer peek() {
			if (stack.size() == 0) {
				return -1;
			}
			return stack.peek();
		}

		public Integer min() {
			if (minStack.size() == 0) {
				return -1;
			}
			return minStack.peek();
		}

		public Integer pop() {
			if (stack.size() == 0) {
				return -1;
			}
			if (stack.peek() == minStack.peek()) {
				minStack.pop();
			}
			return stack.pop();
		}

		public void push(Integer item) {
			if (minStack.size() == 0 || item <= minStack.peek()) {
				minStack.push(item);
			}
			stack.push(item);
		}

		@Override
		public String toString() {
			return "stack " + stack + " \nminStack" + minStack;
		}
	}
}
