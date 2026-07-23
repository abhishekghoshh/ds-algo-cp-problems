# PreviousSmallerElement

**Topic:** `stack`  

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=85LWui3FlVk&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=4)

## 📝 Problem Statement

Given an array, find the Previous Smaller Element for each element.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

same as the previous type2 just a little compact, we have reduced the unnecessary if checks

```java
	private static void type3() {
		int[] arr = { 1, 3, 2, 4, 3, 3 };
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();
			answer[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.add(arr[i]);
		}
		print(answer);
	}
```

### Approach 2

same as the next greater element

```java
	private static void type2() {
		int[] arr = { 1, 3, 2, 4, 3, 3 };
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
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

### Approach 1: 🔨 Brute Force

brute force

```java
	private static void type1() {

	}
}
```
