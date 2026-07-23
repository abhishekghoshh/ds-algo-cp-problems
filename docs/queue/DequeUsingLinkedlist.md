# DequeUsingLinkedlist

**Topic:** `queue` | **File:** `com/problems/queue/DequeUsingLinkedlist.java`

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
        DeQueue<Integer> queue = new DeQueue<>();
        queue.offer(7);
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
