# LengthOfLoopInLinkedList

**Topic:** `linkedlist`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/find-length-of-loop_8160455)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

no cycle is present early break to reduce extra computation we have found the collision again we will traverse from start, and the slow pointer will also go as it is, and we know that after x distance start and the slow pointer will collide

```java
    private static void type2() {
        Node head = new Node(1, 2, 3, 4, 5);
        Node node1 = new Node(6);
        Node node2 = new Node(7, 8, 9);
        Node.attach(head, node1, node2);
        print(head);
        node2.last(node1);

        int n = 0;
        Node start = head;
        Node slow = head;
        Node fast = head;
        while (null != fast && null != fast.next) {
            // no cycle is present early break to reduce extra computation
            if (fast.next.next == null) break;
            slow = slow.next;
            fast = fast.next.next;
            // we have found the collision
            if (slow == fast) {
                // again we will traverse from start,
                // and the slow pointer will also go as it is,
                // and we know that after x distance start and the slow pointer will collide
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                Node node = start;
                n = 1;
                while (null != node && node.next != start) {
                    node = node.next;
                    n++;
                }
                break;
            }
        }
        System.out.println("list length " + n);
    }
```

### Approach 1: 🔨 Brute Force

Using brute force approach Using a set to get the starting point

```java
    private static void type1() {
        Node head = new Node(1, 2, 3, 4, 5);
        Node node1 = new Node(6);
        Node node2 = new Node(7, 8, 9);
        Node.attach(head, node1, node2);
        print(head);
        node2.last(node1);

        Set<Node> set = new HashSet<>();
        while (null != head) {
            if (set.contains(head)) break;
            set.add(head);
            head = head.next;
        }
        Node start = head;
        int n = 1;
        while (null != start && start.next != head) {
            start = start.next;
            n++;
        }
        System.out.println("list length " + n);
    }
}
```
