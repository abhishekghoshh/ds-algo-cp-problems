# Stack

## Overview

**32 files** covering stack implementations, monotonic stack problems, expression evaluation (infix/postfix/prefix), and histogram-based problems.

## Prerequisite Data Structures

### ArrayStack (`com/ds/stack/ArrayStack.java`)

```java
public class ArrayStack<T> implements Stack<T> {
    public void push(T elem)  // O(1) amortized, doubles capacity
    public T pop()             // O(1)
    public T peek()            // O(1)
    public int size()          // O(1)
    public boolean isEmpty()   // O(1)
}
```

### LinkedListStack (`com/ds/stack/LinkedListStack.java`)

Singly linked list based stack with search capability.

## Problem Categories

### Stack Implementations

| Problem | Approach |
|---------|----------|
| **Stack using Arrays** | Dynamic array with top pointer |
| **Stack using LinkedList** | Push = add to head |
| **Stack using Queue** | Two queues: push O(1), pop O(n) |
| **Queue using Stack** | Two stacks: push O(1), pop amortized O(1) |
| **Min Stack** | Two stacks: one for values, one for mins |

### Expression Evaluation (Infix / Postfix / Prefix)

```
Conversions:
  Infix → Postfix: operator precedence + stack
  Infix → Prefix:  reverse + infix-to-postfix + reverse result
  Postfix → Infix: scan left to right, combine when operator
  Prefix → Infix:  scan right to left, combine when operator
  Postfix → Prefix:similarly with stack
  Prefix → Postfix: similarly with stack
  Evaluate RPN:    push operands, pop & compute on operator
```

**Infix to Postfix Algorithm:**
```java
for each token:
    if operand: add to output
    if '(': push to stack
    if ')': pop until '('
    if operator:
        while stack top has >= precedence: pop to output
        push operator
pop remaining operators to output
```

### Monotonic Stack Problems

The core pattern: maintain stack in increasing/decreasing order, popping elements when a violation occurs.

```java
// Next Greater Element (monotonic decreasing stack):
Stack<Integer> stack = new Stack<>();
for (int i = n-1; i >= 0; i--) {
    while (!stack.isEmpty() && arr[stack.peek()] <= arr[i])
        stack.pop();
    result[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
    stack.push(i);
}
```

| Problem | Stack Type | Direction |
|---------|-----------|-----------|
| **Next Greater Element** | Decreasing | Right to left (or left to right) |
| **Next Greater in Circle** | Decreasing | Double array length |
| **Next Smaller Element** | Increasing | Right to left |
| **Previous Greater** | Decreasing | Left to right |
| **Previous Smaller** | Increasing | Left to right |
| **Number of Greater to Right** | Decreasing + count tracking |
| **Daily Temperatures** | Decreasing, store distance | Next greater variant |
| **Stock Span** | Decreasing, store span count | Previous greater variant |
| **Remove K Digits** | Increasing, keep smallest |

### Largest Rectangle in Histogram - Detailed

```java
// Single-pass monotonic stack approach:
// For each bar, compute area when a smaller bar is found
int max = 0;
Stack<Integer> stack = new Stack<>();
for (int i = 0; i <= n; i++) {
    while (!stack.isEmpty() && (i == n || heights[stack.peek()] > heights[i])) {
        int height = heights[stack.pop()];
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        max = Math.max(max, height * width);
    }
    stack.push(i);
}
// Time: O(n), Space: O(n)
```

### Histogram Variants

| Problem | Technique |
|---------|-----------|
| **Max Rectangle in Binary Matrix** | Histogram per row (1s as heights) |
| **Sum of Subarray Minimums** | Find contribution of each element using left/right smaller |
| **Sum of Subarray Maximums** | Similarly using left/right greater |
| **Sum of Subarray Ranges** | Max - Min per subarray (or max_sum - min_sum) |
| **Trapping Rain Water** | Monotonic stack or two-pointer |
| **Maximum of Minimum for Every Window Size** | Stack + auxiliary processing |

### Other Stack Problems

| Problem | Approach |
|---------|----------|
| **Valid Parentheses** | Push open brackets, match close brackets |
| **Longest Valid Parentheses** | Stack with index tracking |
| **Make String Great** | Remove adjacent same char (different case) |
| **Baseball Game** | Stack for scores |
| **Asteroid Collision** | Stack for surviving asteroids |
| **Celebrity Problem** | Elimination + verification using stack |
| **Make Array Non-decreasing** | Stack-based removal |
