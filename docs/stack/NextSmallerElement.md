# NextSmallerElement

**Topic:** `stack`  

## 🔗 Problem Links

- [📄 InterviewBit](https://www.interviewbit.com/problems/nearest-smaller-element/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/immediate-smaller-element-_1062597)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=nc1AYFyvOR4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=5)

## 📝 Problem Statement

Nearest Smaller Element - Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i. More formally, G[i] for an element A[i] = an element A[j] such that j is maximum possible AND j < i AND A[j] < A[i] Elements for which no smaller element exist, consider next smaller element as -1. Input Format The only argument given is integer array A. Output Format Return the integar array G such that G[i] contains nearest smaller number than A[i].If no such element occurs G[i] should be -1. For Example Input 1: A = [4, 5, 2,

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

same as the next greater element

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

### Approach 1: 🔨 Brute Force

brute force

```java
	private static void type1() {

	}
}
```
