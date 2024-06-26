package com.problems.stack;

import java.util.Stack;

/*
 * Problem link :
 * https://leetcode.com/problems/min-stack/submissions/
 * https://www.codingninjas.com/codestudio/problems/min-stack_3843991
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=asf9P2Rcopo&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=10
 * https://www.youtube.com/watch?v=V09NfaGf2ao
 * 
 * https://takeuforward.org/data-structure/implement-min-stack-o2n-and-on-space-complexity/
 * */
public class MinStack {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	// same as type2
	// it is accepted in leetcode
	private static void type4() {
		MinStack3 stack = new MinStack3();
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(3);
		stack.push(3);
		System.out.println("current stack is " + stack);
		stack.pop();
		System.out.println("popped element " + stack.top());
		stack.pop();
		System.out.println("popped element " + stack.getMin());
		stack.pop();
		System.out.println("popped element " + stack.top());
		System.out.println("current stack is " + stack);
	}

	static class MinStack4 {
		Stack<Long> st = new Stack<Long>();
		Long mini;

		// initialize your data structure here.
		public MinStack4() {
			mini = Long.MAX_VALUE;
		}

		public void push(int value) {
			Long val = (long) value;
			if (st.isEmpty()) {
				mini = val;
				st.push(val);
			} else {
				if (val < mini) {
					st.push(2 * val - mini);
					mini = val;
				} else {
					st.push(val);
				}
			}
		}

		public void pop() {
			if (st.isEmpty()) return;
			Long val = st.pop();
			if (val < mini) mini = 2 * mini - val;
		}

		public int top() {
			Long val = st.peek();
			if (val < mini) return mini.intValue();
			return val.intValue();
		}

		public int getMin() {
			return mini.intValue();
		}
	}

	// almost a brute force approach
	private static void type3() {
		MinStack3 stack = new MinStack3();
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(3);
		stack.push(3);
		System.out.println("current stack is " + stack);
		stack.pop();
		System.out.println("popped element " + stack.top());
		stack.pop();
		System.out.println("popped element " + stack.getMin());
		stack.pop();
		System.out.println("popped element " + stack.top());
		System.out.println("current stack is " + stack);
	}

	static class Pair {
		int item, min;

		Pair(int item, int min) {
			this.item = item;
			this.min = min;
		}
	}

	static class MinStack3 {
		Stack<Pair> stack;

		public MinStack3() {
			stack = new Stack<>();
		}

		public void push(int item) {
			int min;
			if (stack.isEmpty()) min = item;
			else min = Math.min(stack.peek().min, item);
			stack.push(new Pair(item, min));
		}

		public void pop() {
			stack.pop();
		}

		public int top() {
			return stack.peek().item;
		}

		public int getMin() {
			return stack.peek().min;
		}
	}

	// TODO optimized approach
	// see it later
	private static void type2() {
		MinStack2 stack = new MinStack2();
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(3);
		stack.push(3);
		System.out.println("current stack is " + stack);
		System.out.println("popped element " + stack.pop());
		System.out.println("popped element " + stack.pop());
		System.out.println("popped element " + stack.pop());
		System.out.println("current stack is " + stack);
	}

	public static class MinStack2 {
		// we will store the elements in the stack,
		// and we will also use one variable for storing the current minimum element
		// we will derive one logic to store the previous logic
		private Stack<Long> stack = null;
		private Long min;

		// space complexity is O(n)
		// if the item is lesser than the current min then we will push (2*item-min)
		// suppose our current min is x and new item is x-1, so will add {2*(x-1)-x}
		// to the stack, which is x-2 which will be our corrupted value
		// so the newly added item will always be lesser the current min
		// as our current min is x-1
		// so while popping when we encounter any value lesser than the current min then
		// we should know that it is the curred value that we have stored earlier
		// so after popping the current min we have to again find the previous min
		// that we can find easily by doing this=> 2*(x-1)-(x-2) => x
		public MinStack2() {
			stack = new Stack<>();
			min = Long.MAX_VALUE;
		}

		public int peek() {
			return stack.isEmpty() ? Integer.MIN_VALUE : stack.peek().intValue();
		}

		public int min() {
			return stack.isEmpty() ? Integer.MIN_VALUE : min.intValue();
		}

		// time complexity O(1)
		public void push(int value) {
			// if the stack is empty
			// then we can add the item to stack
			// and that element will also be the minimum
			Long val = (long) value;
			if (stack.isEmpty()) {
				min = val;
				stack.add(val);
			} else if (val > min) {
				// if the element is greater than the current min
				// then we can just directly add the element to the stack
				stack.add(val);
			} else {
				// if the element is lesser than the current min
				// then we will store the (2 * val - previous min) into the stack
				// (2 * val - previous min) will always be lesser than equal to the current min
				// which will be our indicator to know that the current top of the stack is the
				// min element
				// (2 * val - min) is not the actual value, it is a corrupted value
				stack.add(2 * val - min);
				min = val;
			}
		}

		public int pop() {
			if (stack.isEmpty()) return Integer.MIN_VALUE;
			// if current top is greater than current min then we can safely pop
			if (stack.peek() > min) return stack.pop().intValue();
			// current top is the min element
			// first we will save the current min
			// then we will try to find our previous min
			Long tempMin = min;
			// (2 * min - stack.pop()) is our previous min
			min = 2 * min - stack.pop();
			return tempMin.intValue();
		}

		public int top() {
			Long val = stack.peek();
			if (val < min) return min.intValue();
			return val.intValue();
		}

		@Override
		public String toString() {
			return "{\"stack\": " + stack + ", \"min\": " + min + "}";
		}
	}


	// TODO there is an issue in this solution
	// solve this
	private static void type1() {
		MinStack1 stack = new MinStack1();
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(3);
		stack.push(3);
		System.out.println("current stack is " + stack);
		System.out.println("popped element " + stack.pop());
		System.out.println("popped element " + stack.pop());
		System.out.println("popped element " + stack.pop());
		System.out.println("current stack is " + stack);
	}

	public static class MinStack1 {
		// we will use two stack
		// one for storing all the elements
		// another for storing the min elements only
		private final Stack<Integer> stack;
		private final Stack<Integer> minStack;

		// space complexity is O(2n)
		public MinStack1() {
			stack = new Stack<>();
			minStack = new Stack<>();
		}

		// time complexity O(1)
		public Integer peek() {
			return stack.isEmpty() ? Integer.MIN_VALUE : stack.peek();
		}

		// time complexity O(1)
		public Integer min() {
			return minStack.isEmpty() ? Integer.MIN_VALUE : minStack.peek();
		}

		// time complexity O(1)
		public int pop() {
			if (stack.isEmpty()) return -1;
			if (stack.peek() == minStack.peek()) minStack.pop();
			return stack.pop();
		}

		// time complexity O(1)
		public void push(Integer item) {
			if (minStack.isEmpty() || item <= minStack.peek())
				minStack.push(item);
			stack.push(item);
		}

		@Override
		public String toString() {
			return "{\"elements\": " + stack + ", \"min\": " + minStack + "}";
		}
	}
}