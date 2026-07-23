# MinStack

**Topic:** `stack` | **File:** `com/problems/stack/MinStack.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/min-stack/submissions/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/min-stack_3843991)
- [📄 NeetCode](https://neetcode.io/problems/minimum-stack)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=asf9P2Rcopo&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=10)
- [▶ YouTube](https://www.youtube.com/watch?v=V09NfaGf2ao)
- [▶ YouTube](https://www.youtube.com/watch?v=qkLl7nAwDPo)
- [📄 takeUforward](https://takeuforward.org/data-structure/implement-min-stack-o2n-and-on-space-complexity/)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Optimized approach see it again

```java
private static void type3() {
		MinStack3 stack = new MinStack3();
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(3);
		stack.push(3);
		System.out.println("current stack is " + stack);
		System.out.println("popped element " + stack.pop());
		System.out.println("popped element " + stack.pop());
		System.out.println("popped element " + stack.pop());
		System.out.println("current stack is " + stack);
	}
```

### Approach 2

We will store the elements in the stack, and we will also use one variable for storing the current minimum element we will derive one logic to store the previous logic space complexity is O(n) if the item is lesser than the current min then we will push (2*item - min) suppose our current min is x and new item is x-1, so will add (2*(x-1) - x) => which is x-2 which will be our corrupted value, so the newly added item will always be lesser the current min as our current min is x-1 so while popping when we encounter any value lesser than the current min then we should know that it is the curred value that we have stored earlier so after popping the current min we have to again find the previous min that we can find easily by doing this=> (2*(x-1) - (x-2)) => x time complexity O(1) if the stack is empty then we can add the item to stack and that element will also be the minimum if the element is lesser than the current min then we will store the (2 * val - previous min) into the stack (2 * val - previous min) will always be lesser than equal to the current min which will be our indicator to know that the current top of the stack is the min element (2 * val - min) is not the actual value, it is a corrupted value updating min with the current val if the element is greater than the current min then we can just directly add the element to the stack if the current top is lesser than the min element then it is the corrupted value so, we will try to find our previous min if val is lesser than the min then it is the corrupted value, we should return the min almost a brute force approach rather creating 2 stacks we can just push pairs in the stack [val,min]

**Complexity:** Time: o(1)

```java
private static void type2() {
		MinStack2 stack = new MinStack2();
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(3);
		stack.push(3);
		System.out.println("current stack is " + stack);
		stack.pop();
		System.out.println("popped element " + stack.top());
		stack.pop();
		System.out.println("popped element " + stack.getMin());
		stack.pop();
		System.out.println("popped element " + stack.top());
		System.out.println("current stack is " + stack);
	}
```

### Approach 1 — Brute Force

There is an issue in this solution we will use two stack one for storing all the elements another for storing the min elements only

```java
private static void type1() {
		MinStack1 stack = new MinStack1();
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(3);
		stack.push(3);
		System.out.println("stack is " + stack);
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println("stack is " + stack);
	}
```
