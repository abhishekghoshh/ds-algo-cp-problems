# NextSmallerElement

**Topic:** `stack` | **File:** `com/problems/stack/NextSmallerElement.java`

## Problem Links

- [📄 InterviewBit](https://www.interviewbit.com/problems/nearest-smaller-element/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/immediate-smaller-element-_1062597)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=nc1AYFyvOR4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=5)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Same as the previous type2 just a little compact, we have reduced the unnecessary if checks

```java
private static void type3() {
		int[] arr = { 1, 3, 2, 4, 3, 3 };
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();
			answer[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.add(arr[i]);
		}
		print(arr);
		print(answer);
		
	}
```

### Approach 2

Same as the next greater element

```java
private static void type2() {
		int[] arr = { 1, 3, 2, 4, 3, 3 };
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				answer[i] = -1;
			} else {
				if (stack.peek() < arr[i]) {
					answer[i] = stack.peek();
				} else {
					while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();
					if (stack.isEmpty()) answer[i] = -1;
					else answer[i] = stack.peek();
				}
			}
			stack.add(arr[i]);
		}
		print(arr);
		print(answer);
	}
```

### Approach 1 — Brute Force

Brute force

```java
private static void type1() {

	}
```
