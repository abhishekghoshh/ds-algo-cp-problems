# ReverseStack

**Topic:** `recursion` | **File:** `com/problems/recursion/ReverseStack.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/reverse-stack-using-recursion_631875)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/reverse-stack-using-recursion_631875)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=8YXQ68oHjAs&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=9)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
		Stack<Integer> stack = stack(1, 2, 3, 4, 5, 6, 7, 8, 9);
		reverse(stack);
		print(stack);
	}
	private static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) return;
		int top = stack.pop();
		reverse(stack);
		insertAtBottom(stack, top);
	}
	private static void insertAtBottom(Stack<Integer> stack, int item) {
		if (stack.isEmpty()) {
			stack.push(item);
			return;
		}
		int top = stack.pop();
		insertAtBottom(stack, item);
		stack.push(top);
	}
```
