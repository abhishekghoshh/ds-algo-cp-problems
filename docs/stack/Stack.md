# Stack

**Topic:** `stack` | **File:** `com/problems/stack/Stack.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/stack-implementation-using-array_3210209)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=GYptUgnIM_I)
- [▶ YouTube](https://www.youtube.com/watch?v=P1bAPZg5uaE&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd)
- [📄 takeUforward](https://takeuforward.org/data-structure/implement-stack-using-array/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
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
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
		StackUsingArray<Integer> stack = new StackUsingArray<>(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		printException(() -> stack.push(4));
		System.out.println(stack.peek() + " " + stack.pop());
		System.out.println(stack.peek() + " " + stack.pop());
		System.out.println(stack.peek() + " " + stack.pop());
		printException(() -> System.out.println(stack.peek()));
		printException(() -> System.out.println(stack.pop()));
	}
```
