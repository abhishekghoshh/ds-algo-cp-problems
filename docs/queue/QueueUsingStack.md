# QueueUsingStack

**Topic:** `queue` | **File:** `com/problems/queue/QueueUsingStack.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/implement-queue-using-stacks/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/day-25-:-queue-using-stack_799482)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=tqQ5fTamIN4)
- [▶ YouTube](https://www.youtube.com/watch?v=3Et9MrMc02A)
- [▶ YouTube](https://www.youtube.com/watch?v=eanwa3ht3YQ)
- [📄 takeUforward](https://takeuforward.org/data-structure/implement-queue-using-stack/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
		MyQueue2 queue = new MyQueue2();
		System.out.println("adding 1,2,3,4 to queue");
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		System.out.println("top element " + queue.peek());
		System.out.println("popped element " + queue.pop());
		System.out.println("popped element " + queue.pop());
		System.out.println("popped element " + queue.pop());
		System.out.println("stack is empty " + queue.empty());
		System.out.println("popped element " + queue.pop());
		System.out.println("stack is empty " + queue.empty());
	}
```

### Approach 1 — Brute Force

Push operation complexity is O(1) we are only pushing we will only pop from secondary stack if stack is not empty, then we will directly pop from the secondary, else we will add items from the primary to secondary, the overall time complexity is O(2n) for n items, for max of the time pop will take O(1) time but when the stack is empty then only for that time items are being pushed to secondary, and for n items that can be pushed only n times same ad pop method

```java
private static void type1() {
		MyQueue1 queue = new MyQueue1();
		System.out.println("adding 1,2,3,4 to queue");
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		System.out.println("top element " + queue.peek());
		System.out.println("popped element " + queue.pop());
		System.out.println("popped element " + queue.pop());
		System.out.println("popped element " + queue.pop());
		System.out.println("stack is empty " + queue.empty());
		System.out.println("popped element " + queue.pop());
		System.out.println("stack is empty " + queue.empty());

	}
```
