# StackUsingLinkedlist

**Topic:** `stack` | **File:** `com/problems/stack/StackUsingLinkedlist.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/implement-stack-with-linked-list_1279905)

## Solution Links

- [📄 takeUforward](https://takeuforward.org/data-structure/implement-stack-using-linked-list/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {

    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
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
