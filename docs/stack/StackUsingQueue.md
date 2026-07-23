# StackUsingQueue

**Topic:** `stack` | **File:** `com/problems/stack/StackUsingQueue.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/implement-stack-using-queues/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/stack-using-queue_795152)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=jDZQKzEtbYQ)
- [▶ YouTube](https://www.youtube.com/watch?v=tqQ5fTamIN4)
- [📄 takeUforward](https://takeuforward.org/data-structure/implement-stack-using-single-queue/)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Optimal approach

```java
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
```

### Approach 2

We will use the same queue we will add all previous elements one by one to the queue the last added element will be in the front of the queue front element added to the back

```java
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
```

### Approach 1 — Brute Force

Same as the stack1 just we are switching one queue to another in previous the primary queue will always be source off data and secondary queue will always be a temp variable here when the primary is empty then secondary will be source of data and vice versa, via this we will skip the last swapping from secondary to primary time complexity O(n) space complexity O(2n)

**Complexity:** Time: o(n) | Space: o(2n)

```java
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
```
