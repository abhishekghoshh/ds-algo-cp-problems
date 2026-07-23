# IntroductionToDoublyLinkedList

**Topic:** `linkedlist`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/introduction-to-doubly-linked-list_8160413)

## 🎥 Solution Links

- [📄 takeUforward](https://takeuforward.org/binary-search/introduction-to-doubly-linked-list/)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

we will add a random node lastly, we remove the first dummy pointer

```java
    private static void type2() {
        int[] arr = {4, 2, 5, 1};
        DNode head = new DNode(-1);
        DNode node = head;
        for (int num : arr) {
            DNode current = new DNode(num);
            node.next = current;
            current.prev = node;
            node = current;
        }
        // lastly, we remove the first dummy pointer
        head = head.next;
        head.prev = null;
        print(head);
    }
```

### Approach 1: 🔨 Brute Force

```java
    private static void type1() {
        int[] arr = {4, 2, 5, 1};
        DNode node = null, head = null;
        for (int num : arr) {
            if (node == null) {
                node = new DNode(num);
                head = node;
            } else {
                DNode current = new DNode(num);
                node.next = current;
                current.prev = node;
                node = current;
            }
        }
        print(head);
    }
}
```
