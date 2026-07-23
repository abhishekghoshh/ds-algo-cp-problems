# Queue

**Topic:** `queue` | **File:** `com/problems/queue/Queue.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/implement-queue-using-arrays_8390825)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=M6GnoUDpqEE&t=1s)
- [📄 takeUforward](https://takeuforward.org/data-structure/implement-queue-using-array/)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
		QueueUsingArray<Integer> queue = new QueueUsingArray<>(6);
		queue.offer(4);
		queue.offer(14);
		queue.offer(24);
		queue.offer(34);
		System.out.println("The peek of the queue before deleting any element " + queue.peek());
		System.out.println("The size of the queue before deletion " + queue.size());
		System.out.println("The first element to be deleted " + queue.poll());
		System.out.println("The peek of the queue after deleting an element " + queue.peek());
		System.out.println("The size of the queue after deleting an element " + queue.size());
	}
```
