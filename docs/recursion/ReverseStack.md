# ReverseStack

**Topic:** `recursion`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/reverse-stack-using-recursion_631875)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/reverse-stack-using-recursion_631875)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=8YXQ68oHjAs&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=9)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

we will divide the reversing process into multiple steps 1. take the top element 2. reverse the remaining stack 3. inset the top element at the bottom we can divide the insert at the bottom process into multiple steps 1. check it is empty or not if it is empty, then add that element 2.

else take the top element call the insertAtBottom with the same element 3. after the function call finishes, add the top element back to the stack

```java
	private static void type1() {
		Stack<Integer> stack = stack(1, 2, 3, 4, 5, 6, 7, 8, 9);
		reverse(stack);
		print(stack);
	}

	// we will divide the reversing process into multiple steps
	// 1. take the top element
	// 2. reverse the remaining stack
	// 3. inset the top element at the bottom
	private static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) return;
		int top = stack.pop();
		reverse(stack);
		insertAtBottom(stack, top);
	}

	// we can divide the insert at the bottom process into multiple steps
	// 1. check it is empty or not if it is empty, then add that element
	// 2. else take the top element call the insertAtBottom with the same element
	// 3. after the function call finishes, add the top element back to the stack
	private static void insertAtBottom(Stack<Integer> stack, int item) {
		if (stack.isEmpty()) {
			stack.push(item);
			return;
		}
		int top = stack.pop();
		insertAtBottom(stack, item);
		stack.push(top);
	}

}
```
