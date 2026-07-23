# NextGreaterElement

**Topic:** `stack`  

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2)
- [▶ YouTube](https://www.youtube.com/watch?v=Du881K7Jtk8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=75)

## 📝 Problem Statement

Given an array, find the next greater element for each element (first greater element to the right).

## 💡 Approaches

This problem can be solved in **4** different ways, each improving upon the previous:

### Approach 4: 🏆 Optimal Solution

stack is empty that mean for the current element there is no next greater add the current item to stack as we know There is no lesser element on stack or the lesser items have been deleted

```java
	private static void type4() {
		int[] nums = {1, 3, 2, 4, 3, 3};
		int n = nums.length;
		int[] answer = new int[n];
		int top = -1;
		int[] stack = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			while (top != -1 && stack[top] <= nums[i]) top--;
			// stack is empty that mean for the current element there is no next greater
			answer[i] = top == -1 ? -1 : stack[top];
			// add the current item to stack as we know
			// There is no lesser element on stack or the lesser items
			//have been deleted
			stack[++top] = nums[i];
		}
		print(answer);
	}
```

### Approach 3

same as the previous type2 just a little compact, I have reduced the unnecessary if checks stack is empty that mean for the current element there is no next greater add the current item to stack as we know There is no lesser element on stack or the lesser items have been deleted

```java
	private static void type3() {
		int[] nums = { 1, 3, 2, 4, 3, 3 };
		int n = nums.length;
		int[] answer = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= nums[i]) stack.pop();
			// stack is empty that mean for the current element there is no next greater
			answer[i] = stack.isEmpty() ? -1 : stack.peek();
			// add the current item to stack as we know
			// There is no lesser element on stack or the lesser items
			//have been deleted
			stack.add(nums[i]);
		}
		print(answer);
	}
```

### Approach 2

we will use a stack to store all the previous values we can also use a array a make that use as a stack as here we want the next greater element so we will traverse from the last on the first time there will be no item on stack, so for the right most element there will be no next greater if the current peek is greater than the current element we will pop until there is any greater element found stack is empty that mean for the current element there is no next greater on each iteration we will store the current element

```java
	private static void type2() {
		int[] arr = { 1, 3, 2, 4, 3, 3 };
		int n = arr.length;
		int[] answer = new int[n];
		// we will use a stack to store all the previous values
		// we can also use a array a make that use as a stack
		Stack<Integer> stack = new Stack<>();
		// as here we want the next greater element so we will traverse from the last
		for (int i = n - 1; i >= 0; i--) {
			// on the first time there will be no item on stack, so
			// for the right most element there will be no next greater
			if (stack.isEmpty()) {
				answer[i] = -1;
			} else {
				// if the current peek is greater than the current element
				if (stack.peek() > arr[i]) {
					answer[i] = stack.peek();
				} else {
					// we will pop until there is any greater element found
					while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
					// stack is empty that mean for the current element there is no next greater
					if (stack.isEmpty()) answer[i] = -1;
					else answer[i] = stack.peek();
				}
			}
			// on each iteration we will store the current element
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
