package problems.stack;

import java.util.LinkedList;
import java.util.Queue;
/*
 * Problem link :
 * https://leetcode.com/problems/implement-stack-using-queues/
 * 
 * Solution link :
 * 
 * 
 * */
public class StackUsingQueue {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {
		MyStack3 stack = new MyStack3();
		System.out.println("adding 1,2,3 to stack");
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println("top element " + stack.top());
		System.out.println("popped element " + stack.pop());
		System.out.println("popped element " + stack.pop());
		System.out.println("popped element " + stack.pop());
		System.out.println("stack is empty " + stack.empty());
	}

	private static class MyStack3 {
		Queue<Integer> queue;

		public MyStack3() {
			queue = new LinkedList<>();
		}

		// we will use the same queue
		// we will add all previous element one by one to the queue
		// the the last added element will be in the front of the queue
		public void push(int x) {
			int size = queue.size();
			queue.offer(x);
			while (size-- != 0) {
				// front element added to the back
				queue.offer(queue.poll());
			}
		}

		public int pop() {
			return queue.poll();
		}

		public int top() {
			return queue.peek();
		}

		public boolean empty() {
			return queue.isEmpty();
		}
	}

	private static void type2() {
		MyStack2 stack = new MyStack2();
		System.out.println("adding 1,2,3 to stack");
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println("top element " + stack.top());
		System.out.println("popped element " + stack.pop());
		System.out.println("popped element " + stack.pop());
		System.out.println("popped element " + stack.pop());
		System.out.println("stack is empty " + stack.empty());
	}

	private static class MyStack2 {
		Queue<Integer> primary;
		Queue<Integer> secondary;

		public MyStack2() {
			primary = new LinkedList<>();
			secondary = new LinkedList<>();
		}

		// same as the stack1
		// just we are switching one queue to another
		// in previous the primary queue will always be source off data and secondary
		// queue will always be a temp variable
		// here when the primary is empty then secondary will be source of data and vice
		// versa, via this we will skip the last swapping from secondary to primary
		// time complexity O(n)
		// space complexity O(2n)
		public void push(int x) {
			Queue<Integer> primary = secondary.isEmpty() ? this.primary : this.secondary;
			Queue<Integer> secondary = primary == this.primary ? this.secondary : this.primary;
			secondary.offer(x);
			while (!primary.isEmpty()) {
				secondary.offer(primary.poll());
			}
		}

		public int pop() {
			return primary.size() != 0 ? primary.poll() : secondary.poll();
		}

		public int top() {
			return primary.size() != 0 ? primary.peek() : secondary.peek();
		}

		public boolean empty() {
			return primary.isEmpty() && secondary.isEmpty();
		}
	}

	private static void type1() {
		MyStack1 stack = new MyStack1();
		System.out.println("adding 1,2,3 to stack");
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println("top element " + stack.top());
		System.out.println("popped element " + stack.pop());
		System.out.println("popped element " + stack.pop());
		System.out.println("popped element " + stack.pop());
		System.out.println("stack is empty " + stack.empty());
	}

	private static class MyStack1 {
		Queue<Integer> primary;
		Queue<Integer> secondary;

		public MyStack1() {
			primary = new LinkedList<>();
			secondary = new LinkedList<>();
		}

		// we will use the secondary queue as a temp variable
		// we are basically performing 3 operation here
		// first add the item to secondary queue
		// item by item move all the element from primary to secondary
		// so at the secondary queue the last added item will be on the front
		// item by item move all the element from secondary to primary
		// now all the elements are now again in primary and secondary is empty
		// time complexity O(2n)
		// space complexity O(2n)
		public void push(int x) {
			secondary.offer(x);
			while (!primary.isEmpty()) {
				secondary.offer(primary.poll());
			}
			while (!secondary.isEmpty()) {
				primary.offer(secondary.poll());
			}
		}

		public int pop() {
			return primary.poll();
		}

		public int top() {
			return primary.peek();
		}

		public boolean empty() {
			return primary.isEmpty();
		}
	}
}
